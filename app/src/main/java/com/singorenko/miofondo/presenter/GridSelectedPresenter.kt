package com.singorenko.miofondo.presenter

import com.singorenko.miofondo.manager.GridSelectedManager
import com.singorenko.miofondo.model.GridSelectedModel

class GridSelectedPresenter(private val mView: GridSelectedManager.View): GridSelectedManager.Presenter {

    private val model: GridSelectedManager.Model = GridSelectedModel(this)

    override fun getUrlImagesView(arrayListUrlImages: ArrayList<String>) {
        mView.getUrlImagesView(arrayListUrlImages)
    }

    override fun getUrlImagesModel(categorySelected: String) {
        model.getUrlImagesModel(categorySelected)
    }
}