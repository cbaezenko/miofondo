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
import com.singorenko.miofondo.helper.Constants
import com.singorenko.miofondo.helper.adapter.GridCategoryAdapter
import com.singorenko.miofondo.manager.CategoryAdapterListener
import com.singorenko.miofondo.manager.GridCategoryManager
import com.singorenko.miofondo.model.CategoryModel
import com.singorenko.miofondo.presenter.GridCategoryPresenter
import kotlinx.android.synthetic.main.fragment_grid_categoy.*
import java.lang.ClassCastException

private const val ARG_TWO_PANES = "twoPanes"

class GridCategoryFragment : Fragment(), CategoryAdapterListener, GridCategoryManager.View {

    private val mPresenter: GridCategoryManager.Presenter = GridCategoryPresenter(this)
    private val constants: Constants = Constants()

    override fun getCategoryListView(arrayList: ArrayList<CategoryModel>) {
        rv_grid_category.adapter = GridCategoryAdapter(arrayList, context!!, this, twoPanes)
    }

    lateinit var mGridCategoryListener: GridCategoryListener

    var twoPanes: Boolean = false

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
        arguments?.let {
            twoPanes = it.getBoolean(ARG_TWO_PANES)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_grid_categoy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {

            val sizeScreen: String = if(twoPanes){
                constants.tabletMainCategory
            }else{
                constants.phoneMainCategory
            }

            rv_grid_category.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            mPresenter.getCategoryListModel(sizeScreen)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(twoPanes: Boolean) =
            GridCategoryFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_TWO_PANES, twoPanes)
                }
            }
    }
}
