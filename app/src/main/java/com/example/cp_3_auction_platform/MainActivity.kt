package com.example.cp_3_auction_platform

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //  Variables
    private val SPLASH_TIME_OUT:Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val intent= Intent(this,signup::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}