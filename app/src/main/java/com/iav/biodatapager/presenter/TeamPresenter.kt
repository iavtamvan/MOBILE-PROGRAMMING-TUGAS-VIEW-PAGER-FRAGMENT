package com.iav.biodatapager.presenter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.iav.biodatapager.adapter.TeamAdapter
import com.iav.biodatapager.model.Item
import com.iav.biodatapager.rest.ApiService
import com.iav.biodatapager.rest.RetroConfig
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TeamPresenter(
    private var items: ArrayList<Item> = arrayListOf(),
    private val context: FragmentActivity?,
    private var rv: RecyclerView,
    private var mAdapter: TeamAdapter,
    private var progressBar : ProgressBar,
    private var tvprogres : TextView
) {

    fun getTeam() {
        progressBar.visibility = View.VISIBLE
        tvprogres.visibility = View.VISIBLE
        val service: ApiService = RetroConfig.provideApi()
        service.getTeamByLigaId("4328").subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                items.clear()
                items = result.teams as ArrayList<Item>
                rv.layoutManager = GridLayoutManager(context, 2)
                mAdapter = TeamAdapter(context, items)
                rv.adapter = mAdapter
                progressBar.visibility = View.INVISIBLE
                tvprogres.visibility = View.INVISIBLE
            }, { error ->
                progressBar.visibility = View.INVISIBLE
                tvprogres.visibility = View.INVISIBLE
            })
    }

}