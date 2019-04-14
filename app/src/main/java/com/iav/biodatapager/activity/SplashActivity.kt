package com.iav.biodatapager.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import com.iav.biodatapager.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            finishAffinity()
            startActivity(Intent(this, MainActivity::class.java))
        }, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
