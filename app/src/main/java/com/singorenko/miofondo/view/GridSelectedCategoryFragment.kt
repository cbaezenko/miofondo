package com.singorenko.miofondo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.singorenko.miofondo.R
import com.singorenko.miofondo.helper.adapter.GridSelectedAdapter
import com.singorenko.miofondo.model.CategoryList
import com.singorenko.miofondo.model.CategoryModel
import kotlinx.android.synthetic.main.fragment_grid_selected_category.*

class GridSelectedCategoryFragment : Fragment() {

    var mCategorySelectedList: ArrayList<CategoryModel> = CategoryList().getCategory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid_selected_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_grid_selected_category.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        rv_grid_selected_category.adapter = GridSelectedAdapter(mCategorySelectedList, context!!)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GridSelectedCategoryFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
