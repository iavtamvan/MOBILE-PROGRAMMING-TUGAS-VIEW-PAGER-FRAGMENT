package com.iav.biodatapager

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.iav.biodatapager.fragment.FirstFragment
import com.iav.biodatapager.fragment.SecondFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = FragmentPagerItemAdapter(
            supportFragmentManager, FragmentPagerItems.with(this)
                .add("First Apa Ya", FirstFragment::class.java)
                .add("Second Sapa Ya", SecondFragment::class.java)
                .create()
        )

        val viewPager = findViewById(R.id.viewpager) as ViewPager
        viewPager.adapter = adapter

        val viewPagerTab = findViewById(R.id.viewpagertab) as SmartTabLayout
        viewPagerTab.setViewPager(viewPager)
    }
}
