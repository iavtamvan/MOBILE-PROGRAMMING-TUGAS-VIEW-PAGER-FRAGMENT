package com.iav.biodatapager.presenter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.iav.biodatapager.adapter.NextMatchAdapter
import com.iav.biodatapager.model.Item
import com.iav.biodatapager.rest.ApiService
import com.iav.biodatapager.rest.RetroConfig
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class NextFootballPresenter(
    private var items: ArrayList<Item> = arrayListOf(),
    private val context: FragmentActivity?,
    private var rv: RecyclerView,
    private var mAdapter: NextMatchAdapter,
    private var progressBar : ProgressBar,
    private var tvprogres : TextView
) {

    fun getNextMatch(id: String) {
        progressBar.visibility = View.VISIBLE
        tvprogres.visibility = View.VISIBLE
        val service: ApiService = RetroConfig.provideApi()
        service.getNextMatch(id)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                items.clear()
                items = it.events as ArrayList<Item>
                rv.layoutManager = LinearLayoutManager(context)
                mAdapter = NextMatchAdapter(context, items)
                rv.adapter = mAdapter
                progressBar.visibility = View.INVISIBLE
                tvprogres.visibility = View.INVISIBLE
            }, {
                error("errror" + it.localizedMessage)
                progressBar.visibility = View.INVISIBLE
                tvprogres.visibility = View.INVISIBLE
            })
    }
}