package com.singorenko.miofondo.model
import com.singorenko.miofondo.R

var categoryList: ArrayList<CategoryModel> = ArrayList()

class CategoryList {

    fun getCategory () : ArrayList<CategoryModel> {
        categoryList.add(CategoryModel("Chile", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Spain", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Rusia", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("USA", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Argentina", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Mexico", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("China", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Japon", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("India", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Heraldica", R.drawable.ic_launcher_background))
        return  categoryList
    }
}