package com.singorenko.miofondo.model
import com.singorenko.miofondo.R

var categoryList: ArrayList<CategoryModel> = ArrayList()

class CategoryList {

    fun getCategory () : ArrayList<CategoryModel> {
        categoryList.add(CategoryModel("Argentina",
            "https://cdn.pixabay.com/photo/2017/06/24/14/13/buenos-aires-2437858_960_720.jpg"))
        categoryList.add(CategoryModel("Australia", "https://cdn.pixabay.com/photo/2018/05/07/22/08/sydney-opera-house-3381786_960_720.jpg"))
        categoryList.add(CategoryModel("Brazil", "https://cdn.pixabay.com/photo/2016/04/03/02/28/rio-1303951_960_720.jpg"))
        categoryList.add(CategoryModel(
            "Chile",
            "https://images.pexels.com/photos/66092/pexels-photo-66092.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))
        categoryList.add(CategoryModel("China", "https://cdn.pixabay.com/photo/2017/12/16/16/37/great-wall-3022907_960_720.jpg"))
        categoryList.add(CategoryModel("Cuba", "https://cdn.pixabay.com/photo/2017/03/30/12/21/cuba-2188179_960_720.jpg"))
        categoryList.add(CategoryModel("Egypt", "https://images.pexels.com/photos/91409/pexels-photo-91409.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))
        categoryList.add(CategoryModel("France", "https://images.pexels.com/photos/532826/pexels-photo-532826.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))
        categoryList.add(CategoryModel("India", "https://images.pexels.com/photos/602607/pexels-photo-602607.png?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))
        categoryList.add(CategoryModel("Israel", "https://cdn.pixabay.com/photo/2016/01/04/06/26/jerusalem-1120372_960_720.jpg"))
        categoryList.add(CategoryModel("Italy", "https://cdn.pixabay.com/photo/2018/02/04/17/11/venice-3130323_960_720.jpg"))
        categoryList.add(CategoryModel("Japan", "https://cdn.pixabay.com/photo/2013/06/11/02/58/sunset-129503_960_720.jpg"))
        categoryList.add(CategoryModel("Mexico", "https://cdn.pixabay.com/photo/2015/11/05/23/02/chichen-itza-1025099_960_720.jpg"))
        categoryList.add(CategoryModel("Morocco", "https://cdn.pixabay.com/photo/2015/12/20/13/16/desert-1101123_960_720.jpg"))
        categoryList.add(CategoryModel("Norway", "https://cdn.pixabay.com/photo/2015/11/07/19/19/aurora-borealis-1032523_960_720.jpg"))
        categoryList.add(CategoryModel(
            "Russia",
            "https://images.pexels.com/photos/753339/pexels-photo-753339.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))
        categoryList.add(CategoryModel("Spain", "https://cdn.pixabay.com/photo/2016/06/14/11/05/windmill-1456280_960_720.jpg"))
        categoryList.add(CategoryModel("Turkey", "https://cdn.pixabay.com/photo/2018/12/31/18/27/mosque-3905675_960_720.jpg"))
        categoryList.add(CategoryModel("UK", "https://cdn.pixabay.com/photo/2016/02/19/10/41/big-ben-1209360_960_720.jpg"))
        categoryList.add(CategoryModel("USA", "https://cdn.pixabay.com/photo/2016/02/19/11/50/statue-of-liberty-1210001_960_720.jpg"))
        return  categoryList
    }
}