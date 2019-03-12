package com.singorenko.miofondo.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintLayout
import com.singorenko.miofondo.R
import com.singorenko.miofondo.helper.Constants
import com.singorenko.miofondo.manager.UrlManagerListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GridCategoryFragment.GridCategoryListener,
 GridSelectedCategoryFragment.GridSelectedCategoryListener, UrlManagerListener
{
    override fun onUrlIntentRequest(urlString: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlString))
        startActivity(intent)
    }

    var twoPanes: Boolean = false
    val mConstants: Constants = Constants()

    override fun onGridSelectedCategoryListener(urlImage: String) {
        supportFragmentManager.beginTransaction().add(R.id.fragment_container_selected, SelectedImageFragment.newInstance(twoPanes, urlImage))
            .addToBackStack(null)
            .commit()
    }

    override fun onCategoryClicked(category: String) {
        //twoPanes false means phone
        if(twoPanes){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_selected, GridSelectedCategoryFragment.newInstance(twoPanes, category))
                .addToBackStack(null)
                .commit()
        }
        else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GridSelectedCategoryFragment.newInstance(twoPanes, category))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (findViewById<ConstraintLayout>(R.id.layout_two_pane) != null){
            twoPanes = true
        }

        if(savedInstanceState == null) {
            if(twoPanes){
             supportFragmentManager.beginTransaction()
                 .add(R.id.fragment_container_category, GridCategoryFragment.newInstance(twoPanes))
                 .commit()
             supportFragmentManager.beginTransaction()
                 .add(R.id.fragment_container_selected, GridSelectedCategoryFragment.newInstance(twoPanes, mConstants.defaultEmpty))
                 .commit()
            }else {
                supportFragmentManager.beginTransaction().add(
                    R.id.fragment_container,
                    GridCategoryFragment.newInstance(twoPanes)
                ).commit()
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
                    .replace(R.id.fragment_container_selected, LicenseFragment.newInstance())
                    .commit()
            }else {
                val intent = Intent(this, LicenseActivity::class.java)
                startActivity(intent)
            }
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}
