package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singorenko.miofondo.R

class MainActivity : AppCompatActivity(), GridCategoryFragment.GridCategoryListener {
//    override fun onCategoryClicked(category: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
    override fun onCategoryClicked(category: String) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            GridSelectedCategoryFragment.newInstance()).commit()
    }

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
