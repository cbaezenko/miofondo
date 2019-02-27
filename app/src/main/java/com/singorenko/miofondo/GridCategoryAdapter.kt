package com.singorenko.miofondo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GridCategoryAdapter (val items: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<GridCategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridCategoryViewHolder {
        return GridCategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: GridCategoryViewHolder, position: Int) {
    }
}


class GridCategoryViewHolder (view: View) : RecyclerView.ViewHolder(view){

}