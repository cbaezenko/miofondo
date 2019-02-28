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

    var mCategorySelectedList: ArrayList<String> = ArrayList()

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

        mCategorySelectedList.add("https://images.idgesg.net/images/article/2017/08/android_robot_logo_by_ornecolorada_cc0_via_pixabay1904852_wide-100732483-large.jpg")
        mCategorySelectedList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3kiXoSMVj9shVwVpLwFRhSQSD2ySPqXmpHo_IjG6jz-dvD5ea")
        mCategorySelectedList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9gMn3IpapLQmRWjJXaBi3A32hKFNVW8NjmKcMDGbQOxasd8BG")
        mCategorySelectedList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvTk8w7BP38fbkcN8Dofbz41ockUONuUJetVrW3YcvwiqEI8-X")


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
