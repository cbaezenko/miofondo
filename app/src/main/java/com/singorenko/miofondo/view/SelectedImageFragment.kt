package com.singorenko.miofondo.view

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
            Log.d("TAG", "selected the image to use as background")

            doAsync{
                setWallpaper("https://raw.githubusercontent.com/square/picasso/master/website/static/sample.png")
            }.execute()

//
//            var wallpaperImage: Bitmap = Picasso.get().load("https://raw.githubusercontent.com/square/picasso/master/website/static/sample.png").get()
//            var mWallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
//            try {
//                mWallpaperManager.setBitmap(wallpaperImage)
//            } catch (e: IOException){
//                e.printStackTrace()
//            }
        }
    }

    fun setWallpaper(urlImage: String){
        val wallpaperImage: Bitmap = Picasso.get().load(urlImage).get()
        val mWallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
        try {
            mWallpaperManager.setBitmap(wallpaperImage)
        } catch (e: IOException){
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

     class doAsync(val handler: ()-> Unit) : AsyncTask<Void, Void, Void>(){
         override fun doInBackground(vararg params: Void?): Void? {
             handler()
             return null
         }
    }
}
