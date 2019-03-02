package com.singorenko.miofondo.model
import com.singorenko.miofondo.R

var categoryList: ArrayList<CategoryModel> = ArrayList()

class CategoryList {

    fun getCategory () : ArrayList<CategoryModel> {
        categoryList.add(CategoryModel("Argentina", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Australia", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Brazil", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Chile", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("China", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Cuba", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Egypt", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("France", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("India", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Israel", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Italy", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Japan", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Mexico", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Morocco", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Norway", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Russia", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Spain", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("Turkey", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("UK", R.drawable.ic_launcher_background))
        categoryList.add(CategoryModel("USA", R.drawable.ic_launcher_background))
        return  categoryList
    }
}