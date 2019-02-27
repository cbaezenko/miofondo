package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singorenko.miofondo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction().add(
            R.id.fragment_container,
            GridCategoryFragment.newInstance()
        ).commit()
    }
}
