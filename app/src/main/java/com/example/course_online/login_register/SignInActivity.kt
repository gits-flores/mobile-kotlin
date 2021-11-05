package com.example.course_online.login_register

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.course_online.MainActivity
import com.example.course_online.R

class SignInActivity : AppCompatActivity() {

    private lateinit var formLayout : LinearLayout
    private lateinit var loginBtn : Button
    private lateinit var gmailLoginBtn : Button
    private lateinit var signUpBtn : TextView
    private lateinit var logoApp : ImageView
    private lateinit var descApp : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        setElement()

    }

    private fun setElement() {

        formLayout = findViewById(R.id.form_layout)
        loginBtn = findViewById(R.id.login_btn)
        gmailLoginBtn = findViewById(R.id.loginGmail_btn)
        signUpBtn = findViewById(R.id.signUp_txt)
        logoApp = findViewById(R.id.iv_logo)
        descApp = findViewById(R.id.tv_descApp)

        loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)

            val options =  ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair.create(logoApp, "logoTransitions"),
                Pair.create(descApp, "descTransitions"),
                Pair.create(gmailLoginBtn, "btnTransitions"),
                Pair.create(formLayout, "layoutTransition")
            )

            startActivity(intent, options.toBundle())
        }

    }
}