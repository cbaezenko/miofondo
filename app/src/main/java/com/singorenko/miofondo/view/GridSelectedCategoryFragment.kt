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
import com.singorenko.miofondo.helper.adapter.GridSelectedAdapter
import com.singorenko.miofondo.manager.CategorySelectedListener
import com.singorenko.miofondo.model.CategoryList
import com.singorenko.miofondo.model.CategoryModel
import kotlinx.android.synthetic.main.fragment_grid_selected_category.*
import java.lang.ClassCastException

class GridSelectedCategoryFragment : Fragment(), CategorySelectedListener {

    interface GridSelectedCategoryListener {
        fun onGridSelectedCategoryListener(string: String)
    }

    lateinit var mGridSelectedCategoryListener: GridSelectedCategoryListener

    override fun onClickCategorySelected(imageUrl: String) {
        mGridSelectedCategoryListener.onGridSelectedCategoryListener(imageUrl)
    }

    var mCategorySelectedList: ArrayList<CategoryModel> = CategoryList().getCategory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mGridSelectedCategoryListener = context as GridSelectedCategoryListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement GridSelectedCategoryListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grid_selected_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_grid_selected_category.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        rv_grid_selected_category.adapter = GridSelectedAdapter(mCategorySelectedList, context!!, this)
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
