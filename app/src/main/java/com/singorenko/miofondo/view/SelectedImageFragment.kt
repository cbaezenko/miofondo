package com.singorenko.miofondo.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.singorenko.miofondo.R
import kotlinx.android.synthetic.main.fragment_selected_image.*

class SelectedImageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selected_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        iv_selected_image.setOnClickListener {
            Log.d("TAG", "selected the image to use as background")
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SelectedImageFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
