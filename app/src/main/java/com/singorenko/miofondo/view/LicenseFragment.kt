package com.singorenko.miofondo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.singorenko.miofondo.R

class LicenseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_license, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LicenseFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
