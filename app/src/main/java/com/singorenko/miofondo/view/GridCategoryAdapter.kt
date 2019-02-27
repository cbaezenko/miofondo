package com.singorenko.miofondo.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.model.CategoryModel
import kotlinx.android.synthetic.main.item_inside_category.view.*

class GridCategoryAdapter (val categoryList: ArrayList<CategoryModel>, val context: Context) :
    RecyclerView.Adapter<GridCategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridCategoryViewHolder {
        return GridCategoryViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_category,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: GridCategoryViewHolder, position: Int) {
        holder.tvCategoryTitle.text = categoryList[position].title
    }
}


class GridCategoryViewHolder (view: View) : RecyclerView.ViewHolder(view){
    var tvCategoryTitle: TextView = view.tv_category_title
}