package com.singorenko.miofondo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.singorenko.miofondo.R

class MainActivity : AppCompatActivity(), GridCategoryFragment.GridCategoryListener,
 GridSelectedCategoryFragment.GridSelectedCategoryListener
{
    var twoPanes: Boolean = false

    override fun onGridSelectedCategoryListener(string: String) {
        supportFragmentManager.beginTransaction().add(R.id.fragment_container_selected, SelectedImageFragment.newInstance(twoPanes))
            .addToBackStack(null)
            .commit()
    }

    override fun onCategoryClicked(category: String) {
        //twoPanes false means phone
        if(twoPanes){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_selected, GridSelectedCategoryFragment.newInstance(twoPanes))
                .addToBackStack(null)
                .commit()
        }
        else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GridSelectedCategoryFragment.newInstance(twoPanes))
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
                 .add(R.id.fragment_container_selected, GridSelectedCategoryFragment.newInstance(twoPanes))
                 .commit()
            }else {
                supportFragmentManager.beginTransaction().add(
                    R.id.fragment_container,
                    GridCategoryFragment.newInstance(twoPanes)
                ).commit()
            }
        }
    }
}
