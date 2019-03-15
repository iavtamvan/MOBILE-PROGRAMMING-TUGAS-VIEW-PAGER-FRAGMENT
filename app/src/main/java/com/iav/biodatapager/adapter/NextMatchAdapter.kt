package com.iav.biodatapager.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iav.biodatapager.R
import com.iav.biodatapager.model.Item
import kotlinx.android.synthetic.main.list_next_match.view.*


class NextMatchAdapter : RecyclerView.Adapter<NextMatchAdapter.ViewHolder> {

    private lateinit var context: Context
    private var items: ArrayList<Item>? = null
    private var orig: ArrayList<Item>? = null
//    private var recycleFilter: RecycleFilter? = null

    constructor(context: Context?, items: ArrayList<Item>) : this() {
        this.context = context!!
        this.items = items
        this.orig = items
    }

    constructor()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_next_match, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tanggal.text = items?.get(position)?.dateEvent
        holder.tv_event.text = items?.get(position)?.event

        holder.itemView.setOnClickListener({
            //            val intent = Intent(context, DetailActivity::class.java)
//            intent.putParcelableArrayListExtra("list", items)
//            intent.putExtra("posisi", holder.adapterPosition.toString())
//            intent.putExtra("id", "${items?.get(position)?.lagaId}")
//            context?.startActivity(intent)
        })
    }

    override fun getItemCount(): Int = items?.size as Int

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tanggal = view.tv_tanggal_next
        val tv_event = view.tv_event
    }
}