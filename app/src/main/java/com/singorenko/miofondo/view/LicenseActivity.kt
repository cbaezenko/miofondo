package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singorenko.miofondo.R
import kotlinx.android.synthetic.main.activity_license.*

class LicenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,
                LicenseFragment.newInstance()).commit()
        }

        setSupportActionBar(toolbar_title_about_app)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
