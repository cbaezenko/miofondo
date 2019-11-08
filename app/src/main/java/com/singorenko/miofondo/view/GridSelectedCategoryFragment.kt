package com.singorenko.miofondo.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.singorenko.miofondo.R
import com.singorenko.miofondo.databinding.FragmentGridSelectedCategoryBinding
import com.singorenko.miofondo.helper.Constants
import com.singorenko.miofondo.helper.adapter.GridSelectedAdapter
import com.singorenko.miofondo.manager.CategorySelectedListener
import com.singorenko.miofondo.manager.GridSelectedManager
import com.singorenko.miofondo.presenter.GridSelectedPresenter
import kotlinx.android.synthetic.main.fragment_grid_selected_category.*
import java.lang.ClassCastException

private const val ARG_TWO_PANES = "twoPanes"
private const val ARG_SELECTED_CATEGORY = "selectedCategory"

class GridSelectedCategoryFragment : Fragment(), CategorySelectedListener, GridSelectedManager.View {

    private lateinit var recyclerViewGridSeletecCategory: RecyclerView

    /**
     * set the arrayListUrl with FireStore data to fill the recycler adapter
     */
    override fun getUrlImagesView(arrayListUrlImages: ArrayList<String>) {
        mCategorySelectedList = arrayListUrlImages
        if (mCategorySelectedList.size > 0) {
            rv_grid_selected_category.adapter = GridSelectedAdapter(mCategorySelectedList, context!!, this, twoPanes)
        }
    }

    private val spanCounts: Int = 3
    private var twoPanes: Boolean = false
    private var selectedCategory: String? = ""
    private val mPresenter: GridSelectedManager.Presenter = GridSelectedPresenter(this)

    interface GridSelectedCategoryListener {
        fun onGridSelectedCategoryListener(string: String)
    }

    lateinit var mGridSelectedCategoryListener: GridSelectedCategoryListener
    var mCategorySelectedList: ArrayList<String> = ArrayList()

    override fun onClickCategorySelected(imageUrl: String) {
        mGridSelectedCategoryListener.onGridSelectedCategoryListener(imageUrl)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            twoPanes = it.getBoolean(ARG_TWO_PANES)
            selectedCategory = it.getString(ARG_SELECTED_CATEGORY)
            Log.d("TAG", "twoPanes $twoPanes selectedCategory $selectedCategory")
            if (!twoPanes) {
                selectedCategory = arguments!!.getString("SelectedCategory")
            }
            Log.d("GridSelectedCategory", "SelectedCategory from arguments $selectedCategory")
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentGridSelectedCategoryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_grid_selected_category, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        recyclerViewGridSeletecCategory = bind
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val prefix: String = if(twoPanes){ Constants.tablet } else{ Constants.phone }

        fillCategorySelectedList(prefix+selectedCategory)
        rv_grid_selected_category.layoutManager = GridLayoutManager(context, spanCounts, RecyclerView.VERTICAL, false)
    }

    private fun fillCategorySelectedList(selectedCategory: String?) {
        if (selectedCategory != null && selectedCategory != Constants.defaultEmpty) {
            mPresenter.getUrlImagesModel(selectedCategory)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(twoPanes: Boolean, selectedCategory: String) =
            GridSelectedCategoryFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_TWO_PANES, twoPanes)
                    putString(ARG_SELECTED_CATEGORY, selectedCategory)
                }
            }
    }
}
