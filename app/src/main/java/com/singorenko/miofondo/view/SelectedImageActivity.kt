package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singorenko.miofondo.R
import kotlinx.android.synthetic.main.activity_selected_image.*

class SelectedImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_image)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, SelectedImageFragment.newInstance(false))
            .commit()

        setSupportActionBar(toolbar_selected_image)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
