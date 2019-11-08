package com.singorenko.miofondo.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.singorenko.miofondo.R
import com.singorenko.miofondo.databinding.FragmentLicenseBinding
import com.singorenko.miofondo.manager.UrlManagerListener
import kotlinx.android.synthetic.main.fragment_license.*
import java.lang.ClassCastException

class LicenseFragment : Fragment(), View.OnClickListener {

    lateinit var urlManager: UrlManagerListener

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.privacy_policy_button -> {
                val urlPrivacyPolicy: String = getString(R.string.policy_privacy_url_link)
                urlManager.onUrlIntentRequest(urlPrivacyPolicy)
            }
            R.id.button_github_link ->{
                val urlGithub: String = getString(R.string.github_url_link)
                urlManager.onUrlIntentRequest(urlGithub)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try { urlManager = context as UrlManagerListener }
        catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement UrlManagerListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLicenseBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_license, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        privacy_policy_button.setOnClickListener(this)
        button_github_link.setOnClickListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() = LicenseFragment()
    }
}
