package com.iav.biodatapager.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.iav.biodatapager.R
import com.iav.biodatapager.presenter.MainPresenter

/**
 * A simple [Fragment] subclass.
 *
 */
class SecondFragment : Fragment() {
    private lateinit var mainPresenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)
        val recyclerView :RecyclerView = view.findViewById(R.id.rv)
        mainPresenter = MainPresenter()
        mainPresenter.listBulanHijriah(activity, recyclerView)

        return view
    }
}
