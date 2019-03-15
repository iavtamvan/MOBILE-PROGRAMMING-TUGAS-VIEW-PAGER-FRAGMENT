package com.iav.biodatapager.adapter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.iav.biodatapager.R
import kotlinx.android.synthetic.main.bulan_hijriyah_list_item.view.*

class BulanHijriahAdapter(val items: ArrayList<String>, val context: FragmentActivity?):
    RecyclerView.Adapter<BulanHijriahAdapter.viewHolder>() {

    class viewHolder (view: View) : RecyclerView.ViewHolder(view){
        val tvNamaBulanHijriyah = view.tv_nama_blnhijriah
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate(R.layout.bulan_hijriyah_list_item, p0, false))

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: viewHolder, p1: Int) {
        p0.tvNamaBulanHijriyah?.text = items.get(p1)
        p0.tvNamaBulanHijriyah.setOnClickListener {
            Toast.makeText(context, "" + items.get(p1), Toast.LENGTH_LONG).show()
        }

    }

}