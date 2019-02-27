package com.singorenko.miofondo.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.model.CategoryModel
import com.singorenko.miofondo.model.categoryList
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_inside_category.view.*

class GridCategoryAdapter(private val categoryList: ArrayList<CategoryModel>, private val context: Context) :
    RecyclerView.Adapter<GridCategoryAdapter.GridCategoryViewHolder>() {
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
        holder.ivCategoryImage.setImageDrawable(context.resources.getDrawable(categoryList[position].image))
    }


    class GridCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        override fun onClick(v: View?) {
            val clickedPosition = adapterPosition
            Log.d("TAG", categoryList[clickedPosition].title+ clickedPosition)
            //TODO refresh screen with images of the selected category
        }

        var cvCategory: CardView = view.cv_category
        var tvCategoryTitle: TextView = view.tv_category_title
        var ivCategoryImage: ImageView = view.iv_category_image

        init {
            cvCategory.setOnClickListener(this)
        }
    }
}
