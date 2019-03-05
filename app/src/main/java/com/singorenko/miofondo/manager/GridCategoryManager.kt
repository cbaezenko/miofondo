package com.singorenko.miofondo.manager

import com.singorenko.miofondo.model.CategoryModel

interface GridCategoryManager {
    interface Model{
        fun getCategoryListModel(sizeScreen: String)
    }

    interface View{
        fun getCategoryListView(arrayList: ArrayList<CategoryModel>)
    }

    interface Presenter{
        fun getCategoryListModel(sizeScreen: String)
        fun getCategoryListView(arrayList: ArrayList<CategoryModel>)
    }
}