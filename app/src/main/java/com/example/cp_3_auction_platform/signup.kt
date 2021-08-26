package com.example.cp_3_auction_platform

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btn_register.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@signup, set_password::class.java)
            startActivity(intent)
            finish()
        })

        btn_login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@signup, login::class.java)
            startActivity(intent)
            finish()
        })
    }
}