package com.singorenko.miofondo.model

import android.util.Log
import com.singorenko.miofondo.manager.GridSelectedManager
import com.singorenko.miofondo.presenter.GridSelectedPresenter
import com.google.firebase.firestore.FirebaseFirestore

class GridSelectedModel(private val gridSelectedPresenter: GridSelectedPresenter) : GridSelectedManager.Model {

    private val urlImage: String = "urlImage"
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val tag: String = "GridSelectedModel"
    private var mArrayListImageFromDataBase: ArrayList<String> = ArrayList()

    override fun getUrlImagesModel(categorySelected: String) {
        db.collection(categorySelected)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d(tag, document.id + " => " + document.data)
                        mArrayListImageFromDataBase.add(document.get(urlImage) as String)
                    }
                    gridSelectedPresenter.getUrlImagesView(mArrayListImageFromDataBase)
                } else {
                    Log.d(tag, "Error getting documents: ", task.exception)
                }
            }
    }
}