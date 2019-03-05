package com.singorenko.miofondo.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.singorenko.miofondo.helper.Constants
import com.singorenko.miofondo.manager.GridCategoryManager

class GridCategoryModel(private val mPresenter: GridCategoryManager.Presenter): GridCategoryManager.Model {

    private val constants = Constants()
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val tag: String = "GridCategoryModel"
    private var mArrayListImageFromDataBase: ArrayList<CategoryModel> = ArrayList()

    override fun getCategoryListModel(sizeScreen: String) {
            db.collection(sizeScreen)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            Log.d(tag, document.id + " => " + document.data)
                            mArrayListImageFromDataBase.add(CategoryModel(document.get(constants.nameCategory) as String,
                                document.get(constants.urlImage) as String))
                        }
                        mPresenter.getCategoryListView(mArrayListImageFromDataBase)
                    } else {
                        Log.d(tag, "Error getting documents: ", task.exception)
                    }
                }
    }
}