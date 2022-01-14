package com.example.course_online.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.course_online.R
import com.example.course_online.data.ResponseRegister
import com.example.course_online.network.ApiClient
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var registerBtn: Button
    private lateinit var loginBtn: TextView
    private lateinit var logoApp: ImageView
    private lateinit var descApp: TextView

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
            toLogin()
        }

        registerBtn.setOnClickListener {
            ApiClient.endPoint.Register(
                signUp_name.text.toString(),
                signUp_email.text.toString(),
                signUp_pass.text.toString()
            ).enqueue(object : Callback<ResponseRegister>{
                override fun onResponse(
                    call: Call<ResponseRegister>,
                    response: Response<ResponseRegister>
                ) {
                    if (response.isSuccessful){
                        val response: ResponseRegister? = response.body()
                        Toast.makeText(this@SignUpActivity, "Success $response", Toast.LENGTH_SHORT).show()
                        toLogin()
                    }
                    else{
                        Toast.makeText(this@SignUpActivity, "Failed $response", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                    Toast.makeText(this@SignUpActivity, "Failed $t", Toast.LENGTH_SHORT).show()
                }

            })
        }

    }

    private fun toLogin(){
        onBackPressed()
    }
}