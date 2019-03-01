package com.singorenko.miofondo.helper.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.manager.CategoryAdapterListener
import com.singorenko.miofondo.model.CategoryModel
import com.singorenko.miofondo.view.GridSelectedCategoryActivity
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_inside_category.view.*

class GridCategoryAdapter(
    private val categoryList: ArrayList<CategoryModel>,
    private val context: Context,
    val mFragmentNavListener: CategoryAdapterListener,
    val twoPanes: Boolean
) :
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

    inner class GridCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        override fun onClick(v: View?) {
            val clickedPosition = adapterPosition
            if(twoPanes) {
                mFragmentNavListener.onCategoryClicked(categoryList[clickedPosition].title)
            }else{
                val intent = Intent(context, GridSelectedCategoryActivity::class.java)
                context.startActivity(intent)
            }
        }

        var cvCategory: CardView = view.cv_category
        var tvCategoryTitle: TextView = view.tv_category_title
        var ivCategoryImage: ImageView = view.iv_category_image

        init {
            cvCategory.setOnClickListener(this)
        }
    }
}
