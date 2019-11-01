package com.singorenko.miofondo.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.singorenko.miofondo.R
import com.singorenko.miofondo.databinding.ActivityMainBinding
import com.singorenko.miofondo.helper.Constants
import com.singorenko.miofondo.manager.UrlManagerListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GridCategoryFragment.GridCategoryListener,
        GridSelectedCategoryFragment.GridSelectedCategoryListener, UrlManagerListener {

    override fun onUrlIntentRequest(urlString: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlString)))
    }

    var twoPanes: Boolean = false
    private lateinit var binding: ActivityMainBinding

    override fun onGridSelectedCategoryListener(urlImage: String) {
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainerSelected!!.id, SelectedImageFragment.newInstance(twoPanes, urlImage))
            .addToBackStack(null)
            .commit() }

    override fun onCategoryClicked(category: String) {
        //twoPanes false means phone
        if(twoPanes){
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainerSelected!!.id, GridSelectedCategoryFragment.newInstance(twoPanes, category))
                .addToBackStack(null)
                .commit()
        }}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if ( binding.layoutTwoPane!= null){ twoPanes = true }

        if(savedInstanceState == null) {
            if(twoPanes){
             supportFragmentManager.beginTransaction()
                 .replace(binding.fragmentContainerCategory!!.id, GridCategoryFragment.newInstance(true))
                 .commit()
             supportFragmentManager.beginTransaction()
                 .replace(binding.fragmentContainerSelected!!.id, GridSelectedCategoryFragment.
                     newInstance(true, Constants.defaultEmpty)).commit()
            }
        }
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_licenses -> {
            if(twoPanes){
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainerSelected!!.id, LicenseFragment.newInstance())
                    .commit()
            }else { findNavController(R.id.nav_host_fragment)
                .navigate(R.id.action_gridCategoryFragment_to_licenseFragment) }
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}
