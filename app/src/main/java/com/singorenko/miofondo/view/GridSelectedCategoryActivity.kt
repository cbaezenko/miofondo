package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singorenko.miofondo.R
import kotlinx.android.synthetic.main.activity_grid_selected_category.*

class GridSelectedCategoryActivity : AppCompatActivity(), GridSelectedCategoryFragment.GridSelectedCategoryListener {

    override fun onGridSelectedCategoryListener(string: String) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_selected_category)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, GridSelectedCategoryFragment.newInstance(false))
            .commit()

        setSupportActionBar(toolbar_selected_category)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
