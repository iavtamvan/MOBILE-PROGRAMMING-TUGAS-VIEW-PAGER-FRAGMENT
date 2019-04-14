package com.iav.biodatapager.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.iav.biodatapager.R
import com.iav.biodatapager.activity.DetaiTeamlActivity
import com.iav.biodatapager.model.Item
import kotlinx.android.synthetic.main.list_team.view.*


class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private lateinit var context: Context
    private var items: ArrayList<Item>? = null
    private var orig: ArrayList<Item>? = null

    constructor(context: Context?, items: ArrayList<Item>) : this() {
        this.context = context!!
        this.items = items
        this.orig = items
    }

    constructor()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_team, p0, false))

    override fun getItemCount(): Int = items?.size as Int
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama.text = items?.get(position)?.teamName
        Glide.with(context)
            .load(items?.get(position)?.teamBadge).override(512, 512).into(holder.image)
        holder.legaue.text = items?.get(position)?.strLeague
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetaiTeamlActivity::class.java)
            intent.putExtra("STRTEAM", items?.get(position)?.teamName)
            intent.putExtra("STRLEAGUE", items?.get(position)?.strLeague)
            intent.putExtra("STRSTADIUM", items?.get(position)?.strStadium)
            intent.putExtra("STRKEYWORDS", items?.get(position)?.strKeywords)
            intent.putExtra("STRSTADIUMTHUMB", items?.get(position)?.strStadiumThumb)
            intent.putExtra("STRDESCRIPTIONEN", items?.get(position)?.strDescriptionEN)
            intent.putExtra("STRTEAMBADGE", items?.get(position)?.teamBadge)
            context?.startActivity(intent)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.tv_name_team
        val image = view.img_team
        val legaue = view.tv_name_leagaue
    }
}