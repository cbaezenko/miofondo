package com.singorenko.miofondo.helper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.manager.CategorySelectedListener
import com.singorenko.miofondo.model.CategoryModel
import kotlinx.android.synthetic.main.item_grid_selected_category.view.*

class GridSelectedAdapter(
    private val categorySelectedList: ArrayList<CategoryModel>,
    private val context: Context,
    val mCategorySelectedListener: CategorySelectedListener
) :
    RecyclerView.Adapter<GridSelectedAdapter.GridSelectedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridSelectedViewHolder {
        return GridSelectedViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_grid_selected_category,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: GridSelectedViewHolder, position: Int) {
    }

    inner class GridSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        override fun onClick(v: View?) {
            mCategorySelectedListener.onClickCategorySelected("url")
        }

        private var ivSelectedCategoryImage: ImageView = view.iv_selected_category_image

        init {
            ivSelectedCategoryImage.setOnClickListener(this)
        }
    }
}