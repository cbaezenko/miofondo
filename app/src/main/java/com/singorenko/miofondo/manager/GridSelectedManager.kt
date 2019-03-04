package com.singorenko.miofondo.manager

interface GridSelectedManager {

    interface Model{
    fun getUrlImagesModel(categorySelected: String)
    }

    interface View{
    fun getUrlImagesView(arrayListUrlImages: ArrayList<String>)
    }

    interface Presenter{
        fun getUrlImagesModel(categorySelected: String)
        fun getUrlImagesView(arrayListUrlImages: ArrayList<String>)
    }
}