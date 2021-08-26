package com.example.cp_3_auction_platform

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class login : AppCompatActivity() {
    private lateinit var userid: String
    private lateinit var psw: String
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //      redirect to profile after login
        lgn_btn_login.setOnClickListener(View.OnClickListener {
//          Validation of user id and password
            userid = lgn_btn_login.text.toString().trim()
            psw = lgn_btn_login.text.toString()
            if (userid.isEmpty() && psw.isEmpty()) {
                lgn_et_id.setError("Field can't be empty")
                lgn_et_psw.setError("Field can't be empty")
            } else if (psw.isEmpty()) {
                lgn_et_psw.setError("Field can't be empty")
            } else if (userid.isEmpty()) {
                lgn_et_id.setError("Field can't be empty")
            } else {
                auth.signInWithEmailAndPassword(userid, psw)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success")
                            val user = auth.currentUser
                            var intent1 = Intent(this@login, home_page::class.java)
                            intent1.putExtra("user", userid)
                            startActivity(intent1)
                            finish()
                            Toast.makeText(
                                baseContext,
                                "Authentication successful.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Log.w("TAG", "signInWithEmail:failure", task.exception)
                            val builder = AlertDialog.Builder(this)
                            builder.setMessage("Invalid User id and Password")
                            builder.setTitle("Error")
                            builder.setCancelable(false)
                            builder.setNegativeButton("OK") { dialog, which ->
                                dialog.cancel()
                            }
                            val alertDialog = builder.create()
                            alertDialog.show()
                            Toast.makeText(
                                baseContext,
                                "Authentication Failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

            }
        })

//        Forget Password
        lgn_txt_fgtpsw.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@login, forgetPassword::class.java)
            startActivity(intent)
            finish()
        })

//        redirect to registration after click on sing up
        lgn_txt_signup.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@login, set_password::class.java)

        })
    }
}