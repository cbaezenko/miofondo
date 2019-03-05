package com.singorenko.miofondo.presenter

import com.singorenko.miofondo.manager.GridCategoryManager
import com.singorenko.miofondo.model.CategoryModel
import com.singorenko.miofondo.model.GridCategoryModel

class GridCategoryPresenter(private val mView: GridCategoryManager.View): GridCategoryManager.Presenter{

    private val mModel: GridCategoryManager.Model = GridCategoryModel(this)

    override fun getCategoryListModel(sizeScreen: String) {
    mModel.getCategoryListModel(sizeScreen)
    }

    override fun getCategoryListView(arrayList: ArrayList<CategoryModel>) {
    mView.getCategoryListView(arrayList)
    }
}