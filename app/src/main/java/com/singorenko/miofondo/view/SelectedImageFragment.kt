package com.singorenko.miofondo.view

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog

import com.singorenko.miofondo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_selected_image.*
import java.io.IOException

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
        fun newInstance() =
            SelectedImageFragment().apply {
                arguments = Bundle().apply {
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
