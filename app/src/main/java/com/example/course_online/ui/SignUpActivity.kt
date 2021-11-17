package com.example.course_online.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.course_online.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var registerBtn : Button
    private lateinit var loginBtn : TextView
    private lateinit var logoApp : ImageView
    private lateinit var descApp : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setElement()

    }

    private fun setElement() {
        registerBtn = findViewById(R.id.signUp_btn)
        loginBtn = findViewById(R.id.signIn_txt)
        logoApp = findViewById(R.id.iv_logo)
        descApp = findViewById(R.id.tv_descApp)

        loginBtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        registerBtn.setOnClickListener {

        }

    }
}