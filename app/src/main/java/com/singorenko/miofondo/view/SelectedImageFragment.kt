package com.singorenko.miofondo.view

import android.app.WallpaperManager
//import android.content.Context
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog

import com.singorenko.miofondo.R
//import com.singorenko.miofondo.helper.ToolbarListener
import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_selected_image.*
import java.io.IOException
//import java.lang.ClassCastException

private const val ARG_TWO_PANES = "twoPanes"

class SelectedImageFragment : Fragment() {

//    lateinit var mToolbarListener: ToolbarListener
    var twoPanes: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            twoPanes = it.getBoolean(ARG_TWO_PANES)
        }
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        try {
////            mToolbarListener = context as ToolbarListener
//        } catch (e: ClassCastException){
//            throw ClassCastException(activity.toString() + " must implement ToolbarListener")
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selected_image, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        mToolbarListener.showToolbarRowBack(true)
////        activity?.toolbar?.setNavigationOnClickListener {
////            mToolbarListener.backToFragment(GridSelectedCategoryFragment.newInstance())
////        }
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        iv_selected_image.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            builder.setTitle(getString(R.string.dialog_text_title))
            builder.setMessage(getString(R.string.dialog_text_question_message))
            builder.setPositiveButton(getString(R.string.all_text_accept)) { _, _ ->
                DoAsync {
                    setWallpaper("https://raw.githubusercontent.com/square/picasso/master/website/static/sample.png")
                }.execute()
            }

            builder.setNegativeButton(getString(R.string.all_text_cancel)) { _, _ ->
                //DO NOTHING
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    private fun setWallpaper(urlImage: String) {
        val wallpaperImage: Bitmap = Picasso.get().load(urlImage).get()
        val mWallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
        try {
            mWallpaperManager.setBitmap(wallpaperImage)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(twoPanes: Boolean) =
            SelectedImageFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_TWO_PANES, twoPanes)
                }
            }
    }

    class DoAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            handler()
            return null
        }
    }
}
