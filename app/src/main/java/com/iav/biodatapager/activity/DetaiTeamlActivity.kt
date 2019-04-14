package com.iav.biodatapager.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bumptech.glide.Glide
import com.iav.biodatapager.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetaiTeamlActivity : AppCompatActivity() {
    lateinit var strteam: String
    lateinit var strleague: String
    lateinit var strstadium: String
    lateinit var strkeywords: String
    lateinit var strstadiumthumb: String
    lateinit var strdescriptionen: String
    lateinit var strteambadge: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        strteam = intent.getStringExtra("STRTEAM")
        strleague = intent.getStringExtra("STRLEAGUE")
        strstadium = intent.getStringExtra("STRSTADIUM")
        strkeywords = intent.getStringExtra("STRKEYWORDS")
        strstadiumthumb = intent.getStringExtra("STRSTADIUMTHUMB")
        strdescriptionen = intent.getStringExtra("STRDESCRIPTIONEN")
        strteambadge = intent.getStringExtra("STRTEAMBADGE")

//        toolbar.setTitle(strteam)
        supportActionBar?.setTitle(strteam)

        tvJenisLegaue.text = strleague
        tvNamaStadium.text = strstadium
        tvKeywordsTeam.text = strkeywords
        Glide.with(this).load(strstadiumthumb).override(512, 512).error(android.R.drawable.ic_dialog_info).into(ivStadion)
//        Toast.makeText(this, "" + strstadiumthumb, Toast.LENGTH_LONG).show()
        Glide.with(this).load(strteambadge).override(512, 512).error(android.R.drawable.ic_dialog_info).into(ivLogoTeam)
        tvDeskrisiTeam.text = strdescriptionen

        fab.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody =
                "Shared link from Football " + strteambadge
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Dari")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share Melalui"))
        }
    }
}
