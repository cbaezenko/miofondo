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
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

import com.singorenko.miofondo.R
import com.singorenko.miofondo.databinding.FragmentSelectedImageBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_selected_image.*
import java.io.IOException

private const val ARG_TWO_PANES = "twoPanes"
private const val ARG_URL_IMAGE = "urlImage"

class SelectedImageFragment : Fragment() {

    var twoPanes: Boolean = false
    var urlImage: String = ""

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            twoPanes = it.getBoolean(ARG_TWO_PANES)
            if (twoPanes) { urlImage = it.getString(ARG_URL_IMAGE)!! }
            else { urlImage = arguments!!.getString("SelectedPhoto")!! }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSelectedImageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_selected_image, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
//        MobileAds.initialize(context, context?.resources?.getString(R.string.admob_app_id))
        MobileAds.initialize(context, "ca-app-pub-3940256099942544~3347511713") //test
        mInterstitialAd = InterstitialAd(context)

        mInterstitialAd = InterstitialAd(context).apply {
//            adUnitId = "ca-app-pub-6535027582970176/7248336144"
            adUnitId = "ca-app-pub-3940256099942544~3347511713" //test
            adListener = (object : AdListener (){
                override fun onAdClosed() {
                    super.onAdClosed()
                    Toast.makeText(context, "Wallpaper ready!", Toast.LENGTH_LONG).show()
                }
            })
        }

        Picasso.get().load(urlImage)
            .into(iv_selected_image)

        iv_selected_image.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            builder.setTitle(getString(R.string.dialog_text_title))
            builder.setMessage(getString(R.string.dialog_text_question_message))
            builder.setPositiveButton(getString(R.string.all_text_accept)) { _, _ ->
                showInterstitial()
                when {
                    mInterstitialAd.isLoaded -> {
                        Log.d(tag, "should show the InterstitialAd!")
                        mInterstitialAd.show()
                    }
                    mInterstitialAd.isLoading -> Log.d(tag, "is loading!")
                    else -> Log.d(tag, "The interstitial wasn't loaded yet")
                }

                DoAsync {
                    setWallpaper(urlImage)
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
        try { mWallpaperManager.setBitmap(wallpaperImage) }
        catch (e: IOException) { e.printStackTrace() }
    }

    // Show the ad if it's ready. Otherwise toast and restart the game.
    private fun showInterstitial() {
        if (mInterstitialAd.isLoaded) { mInterstitialAd.show() }
        else { Log.d(tag, "Ad wasn't loaded." ) } }

    companion object {
        @JvmStatic
        fun newInstance(twoPanes: Boolean, urlImage: String) =
            SelectedImageFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_TWO_PANES, twoPanes)
                    putString(ARG_URL_IMAGE, urlImage)
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
