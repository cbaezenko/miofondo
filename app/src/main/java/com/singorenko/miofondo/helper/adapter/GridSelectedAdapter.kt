package com.singorenko.miofondo.helper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.model.CategoryModel
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_inside_category.view.*

class GridSelectedAdapter (private val categorySelectedList: ArrayList<CategoryModel>, private  val context: Context) :
RecyclerView.Adapter<GridSelectedAdapter.GridSelectedViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridSelectedViewHolder {
    return GridSelectedViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_selected_category, parent, false))      }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: GridSelectedViewHolder, position: Int) {
//        holder.tvCategoryTitle.text = categorySelectedList[position].title
    }


    class GridSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        var iv_selected_category_image: TextView = view.tv_category_title
    }
}