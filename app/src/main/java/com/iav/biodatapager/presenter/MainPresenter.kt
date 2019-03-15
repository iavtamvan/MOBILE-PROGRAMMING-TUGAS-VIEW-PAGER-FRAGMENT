package com.iav.biodatapager.presenter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.iav.biodatapager.adapter.BulanHijriahAdapter

class MainPresenter {
    val bulanHijriah: ArrayList<String> = ArrayList()
    val video: ArrayList<String> = ArrayList()
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    fun listBulanHijriah(context: FragmentActivity?, recyclerView: RecyclerView) {

        bulanHijriah.add("Muharram")
        bulanHijriah.add("Safar")
        bulanHijriah.add("Rabiul awal")
        bulanHijriah.add("Rabiul akhir")
        bulanHijriah.add("Jumadil awal")
        bulanHijriah.add("Jumadil akhir")
        bulanHijriah.add("Rajab")
        bulanHijriah.add("Sya'ban")
        bulanHijriah.add("Ramadhan")
        bulanHijriah.add("Rajab")
        bulanHijriah.add("Syawal")
        bulanHijriah.add("Dzulkaidah")
        bulanHijriah.add("Dzulhijjah")
        viewManager = LinearLayoutManager(context)
        viewAdapter = BulanHijriahAdapter(bulanHijriah, context)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter
    }

}