package com.singorenko.miofondo.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singorenko.miofondo.R
import com.singorenko.miofondo.databinding.FragmentGridCategoyBinding
import com.singorenko.miofondo.helper.adapter.GridCategoryAdapter
import com.singorenko.miofondo.manager.CategoryAdapterListener
import com.singorenko.miofondo.manager.GridCategoryManager
import com.singorenko.miofondo.model.CategoryList
import com.singorenko.miofondo.model.CategoryModel
import com.singorenko.miofondo.viewmodel.CategoryListViewModel
import kotlinx.android.synthetic.main.fragment_grid_categoy.*
import java.lang.ClassCastException

private const val ARG_TWO_PANES = "twoPanes"

class GridCategoryFragment : Fragment(), CategoryAdapterListener, GridCategoryManager.View {
    lateinit var navController: NavController
//    lateinit var mViewModel: CategoryListViewModel

    override fun getCategoryListView(arrayList: ArrayList<CategoryModel>) {
        rv_grid_category.adapter = GridCategoryAdapter(arrayList, context!!, this, twoPanes)
    }

    lateinit var mGridCategoryListener: GridCategoryListener

    var twoPanes: Boolean = false

    interface GridCategoryListener { fun onCategoryClicked(category: String) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try { mGridCategoryListener = context as GridCategoryListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement GridCategoryListener")
        }
    }

    override fun onCategoryClicked(category: String) { mGridCategoryListener.onCategoryClicked(category) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { twoPanes = it.getBoolean(ARG_TWO_PANES) }
//        mViewModel = ViewModelProviders.of(this).get(CategoryListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentGridCategoyBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_grid_categoy, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            if(!twoPanes){ navController = Navigation.findNavController(view) }
            rv_grid_category.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            rv_grid_category.adapter = GridCategoryAdapter(CategoryList().getCategory(), context!!, this,twoPanes)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(twoPanes: Boolean) =
            GridCategoryFragment().apply {
                arguments = Bundle().apply { putBoolean(ARG_TWO_PANES, twoPanes) }
            }
    }
}
