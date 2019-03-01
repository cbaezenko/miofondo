package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singorenko.miofondo.R

class GridSelectedCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_selected_category)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, GridSelectedCategoryFragment.newInstance(false))
            .commit()
    }
}
