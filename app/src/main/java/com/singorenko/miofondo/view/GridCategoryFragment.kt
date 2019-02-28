package com.singorenko.miofondo.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.helper.adapter.GridCategoryAdapter
import com.singorenko.miofondo.manager.CategoryAdapterListener
import com.singorenko.miofondo.model.CategoryList
import com.singorenko.miofondo.model.CategoryModel
import kotlinx.android.synthetic.main.fragment_grid_categoy.*
import java.lang.ClassCastException

class GridCategoryFragment : Fragment(), CategoryAdapterListener {

    lateinit var mGridCategoryListener: GridCategoryListener
    var mCategoryList: ArrayList<CategoryModel> = CategoryList().getCategory()

    interface GridCategoryListener {
        fun onCategoryClicked(category: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mGridCategoryListener = context as GridCategoryListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement GridCategoryListener")
        }
    }

    override fun onCategoryClicked(category: String) {
        mGridCategoryListener.onCategoryClicked(category)
    }

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
        rv_grid_category.adapter = GridCategoryAdapter(mCategoryList, context!!, this)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GridCategoryFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}
