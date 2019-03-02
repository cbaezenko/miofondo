package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singorenko.miofondo.R
import kotlinx.android.synthetic.main.activity_selected_image.*


class SelectedImageActivity : AppCompatActivity() {

    var urlImage: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_image)

        if(intent.getStringExtra(Companion.ARG_URL_IMAGE)!=null){
            urlImage = intent.getStringExtra(Companion.ARG_URL_IMAGE)

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SelectedImageFragment.newInstance(false, urlImage))
                .commit()
        }

        setSupportActionBar(toolbar_selected_image)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        public const val ARG_URL_IMAGE = "urlImage"
    }
}
