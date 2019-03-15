package com.iav.biodatapager.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import android.content.Intent
import android.content.ActivityNotFoundException
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.iav.biodatapager.R


/**
 * A simple [Fragment] subclass.
 *
 */
class FourFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_four, container, false)
        val btnFollowMe:Button = view.findViewById(R.id.btnFollowMe)
        val ivImageProfile:ImageView = view.findViewById(R.id.ivImageProfile)
        activity?.let {
            Glide.with(it)
                .load(R.drawable.iav).override(512,512).into(ivImageProfile)
        }
        btnFollowMe.setOnClickListener {
            val uri = Uri.parse("https://instagram.com/iav_ariav")
            val likeIng = Intent(Intent.ACTION_VIEW, uri)

            likeIng.setPackage("com.instagram.android")

            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://instagram.com/iav_ariav")
                    )
                )
            }

        }


        return view

    }


}
