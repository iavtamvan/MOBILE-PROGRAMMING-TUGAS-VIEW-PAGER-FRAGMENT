package com.iav.biodatapager.activity

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.iav.biodatapager.BuildConfig
import com.iav.biodatapager.R
import com.iav.biodatapager.fragment.FirstFragment
import com.iav.biodatapager.fragment.FourFragment
import com.iav.biodatapager.fragment.SecondFragment
import com.iav.biodatapager.fragment.ThirdFragment
import com.kotlinpermissions.KotlinPermissions
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KotlinPermissions.with(this) // where this is an FragmentActivity instance
            .permissions(Manifest.permission.ACCESS_FINE_LOCATION)
            .onAccepted { permissions ->
                //List of accepted permissions
            }
            .onDenied { permissions ->
                //List of denied permissions
            }
            .onForeverDenied { permissions ->
                //List of forever denied permissions
            }
            .ask()

        myname.text = " I " + " A "  + " V "
        mynameCom.text = BuildConfig.APPLICATION_ID
        val adapter = FragmentPagerItemAdapter(
            supportFragmentManager, FragmentPagerItems.with(this)
                .add("Team Match", FirstFragment::class.java)
                .add("Match Next", ThirdFragment::class.java)
                .add("Bulan Hijriah", SecondFragment::class.java)
                .add("Profil", FourFragment::class.java)
                .create()
        )

        val viewPager = findViewById(R.id.viewpager) as ViewPager
        viewPager.adapter = adapter

        val viewPagerTab = findViewById(R.id.viewpagertab) as SmartTabLayout
        viewPagerTab.setViewPager(viewPager)
    }
}
