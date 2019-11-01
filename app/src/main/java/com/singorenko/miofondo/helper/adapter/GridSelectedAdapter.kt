package com.singorenko.miofondo.helper.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.manager.CategorySelectedListener
//import com.singorenko.miofondo.view.SelectedImageActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_grid_selected_category.view.*

class GridSelectedAdapter(
    private val categorySelectedList: ArrayList<String>,
    private val context: Context,
    val mCategorySelectedListener: CategorySelectedListener,
    val twoPanes: Boolean
) :
    RecyclerView.Adapter<GridSelectedAdapter.GridSelectedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridSelectedViewHolder {
        Log.d("TAG", "onCreateViewHolder")
        return GridSelectedViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_grid_selected_category,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categorySelectedList.size
    }

    override fun onBindViewHolder(holder: GridSelectedViewHolder, position: Int) {
        Log.d("adapter", "que hay en el adapter"+categorySelectedList[0])
        Picasso.get().load(categorySelectedList[position]).into(holder.ivSelectedCategoryImage)
    }

    inner class GridSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        override fun onClick(v: View?) {
           if(twoPanes) {
               mCategorySelectedListener.onClickCategorySelected(categorySelectedList[adapterPosition])
           }else{
               var navController = Navigation.findNavController(v!!)
               val bundle = bundleOf("SelectedPhoto" to categorySelectedList[adapterPosition])
               navController.navigate(R.id.action_gridSelectedCategoryFragment_to_selectedImageFragment, bundle)

//                val intent = Intent(context, SelectedImageActivity::class.java)
//               intent.putExtra(SelectedImageActivity.ARG_URL_IMAGE, categorySelectedList[adapterPosition])
//               context.startActivity(intent)
           }
        }

        var ivSelectedCategoryImage: ImageView = view.iv_selected_category_image

        init {
            ivSelectedCategoryImage.setOnClickListener(this)
        }
    }
}