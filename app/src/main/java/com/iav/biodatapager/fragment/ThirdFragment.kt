package com.iav.biodatapager.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.iav.biodatapager.R
import com.iav.biodatapager.adapter.NextMatchAdapter
import com.iav.biodatapager.model.Item
import com.iav.biodatapager.presenter.NextFootballPresenter

/**
 * A simple [Fragment] subclass.
 *
 */
class ThirdFragment : Fragment() {
    private lateinit var nextFootballPresenter: NextFootballPresenter
    private lateinit var nextMatchAdapter: NextMatchAdapter
    private var items: ArrayList<Item> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_third, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv)
        val progressBar: ProgressBar = view.findViewById(R.id.progress)
        val tvProgress: TextView = view.findViewById(R.id.tvProgressBar)
        nextMatchAdapter = NextMatchAdapter(activity, items)
        nextFootballPresenter = NextFootballPresenter(items,activity, recyclerView, nextMatchAdapter, progressBar, tvProgress)
        nextFootballPresenter.getNextMatch("4328")

        return view
    }


}
