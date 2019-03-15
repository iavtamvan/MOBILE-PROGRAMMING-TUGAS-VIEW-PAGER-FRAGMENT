package com.iav.biodatapager

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.iav.biodatapager.fragment.FirstFragment
import com.iav.biodatapager.fragment.FourFragment
import com.iav.biodatapager.fragment.SecondFragment
import com.iav.biodatapager.fragment.ThirdFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
