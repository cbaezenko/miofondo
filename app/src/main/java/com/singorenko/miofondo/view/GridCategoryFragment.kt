package com.singorenko.miofondo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.model.CategoryList
import com.singorenko.miofondo.model.CategoryModel
import kotlinx.android.synthetic.main.fragment_grid_categoy.*

class GridCategoryFragment : Fragment() {

    var mCategoryList: ArrayList<CategoryModel> = CategoryList().getCategory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_grid_categoy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_grid_category.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        rv_grid_category.adapter = GridCategoryAdapter(mCategoryList, context!!)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GridCategoryFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}
