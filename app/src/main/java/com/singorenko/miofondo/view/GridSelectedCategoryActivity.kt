package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singorenko.miofondo.R
import kotlinx.android.synthetic.main.activity_grid_selected_category.*

class GridSelectedCategoryActivity : AppCompatActivity(), GridSelectedCategoryFragment.GridSelectedCategoryListener {

    private var titleCategory: String = ""

    override fun onGridSelectedCategoryListener(string: String) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_selected_category)

        if(intent.getStringExtra(ARG_TITLE_CATEGORY) != null) {

            titleCategory = intent.getStringExtra(ARG_TITLE_CATEGORY)
            toolbar_selected_category.title = titleCategory

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, GridSelectedCategoryFragment.newInstance(false))
                .commit()

            setSupportActionBar(toolbar_selected_category)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    companion object {
        public const val ARG_TITLE_CATEGORY = "ARG_TITLE_CATEGORY"
    }
}
