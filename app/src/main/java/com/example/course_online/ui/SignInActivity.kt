package com.example.course_online.ui

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Pair
import android.widget.*
import com.example.course_online.MainActivity
import com.example.course_online.R
import com.example.course_online.data.DataLogin
import com.example.course_online.data.PrefsManagers
import com.example.course_online.network.ApiClient
import com.example.course_online.ui.PersonalGrowth.PersonalGrowtActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import okhttp3.internal.trimSubstring
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var formLayout: LinearLayout
    private lateinit var loginBtn: Button
    private lateinit var signUpBtn: TextView
    private lateinit var logoApp: ImageView
    private lateinit var descApp: TextView
    lateinit var prefsManagers: PrefsManagers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        prefsManagers = PrefsManagers(this)

        setElement()
        onStart()

    }

    override fun onStart() {
        super.onStart()
        isLogin()
    }

    private fun isLogin() {
        if (prefsManagers.prefsIsLogin){
            Toast.makeText(
                this@SignInActivity,
                prefsManagers.prefsMessage,
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this@SignInActivity, MainActivity::class.java))
            finish()
        }
    }

    private fun setElement() {

        formLayout = findViewById(R.id.form_layout)
        loginBtn = findViewById(R.id.login_btn)
        signUpBtn = findViewById(R.id.signUp_txt)
        logoApp = findViewById(R.id.iv_logo)
        descApp = findViewById(R.id.tv_descApp)

        tv_policy.setOnClickListener {
            startActivity(Intent(this, PersonalGrowtActivity::class.java))
        }

        loginBtn.setOnClickListener {
            ApiClient.endPoint.Login(signIn_email.text.toString(), signIn_pass.text.toString())
                .enqueue(object : Callback<DataLogin> {
                    override fun onResponse(
                        call: Call<DataLogin>,
                        response: Response<DataLogin>
                    ) {
                        if (response.isSuccessful) {
                            val response: DataLogin? = response.body()
                            setPrefs(prefsManagers, response!!)
                            Toast.makeText(
                                this@SignInActivity,
                                prefsManagers.prefsMessage,
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(
                                this@SignInActivity,
                                "Masukkan Data Dengan Benar",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<DataLogin>, t: Throwable) {
                        Toast.makeText(this@SignInActivity, "$t", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair.create(logoApp, "logoTransitions"),
                Pair.create(descApp, "descTransitions"),
                Pair.create(loginBtn, "btnTransitions"),
                Pair.create(tv_policy, "kebijakanTransitions"),
                Pair.create(formLayout, "layoutTransition")
            )

            startActivity(intent, options.toBundle())
        }

    }

    fun setPrefs(prefsManagers: PrefsManagers, responseLog: DataLogin) {
        prefsManagers.prefsIsLogin = true
        prefsManagers.prefsToken = responseLog.token
        prefsManagers.prefsMessage = responseLog.message
        prefsManagers.prefsName = prefsManagers.prefsMessage.replace("Selamat Datang ", "")
        prefsManagers.prefsEmail = signIn_email.text.toString()
//        Log.i("Token", responseLog.token)
    }
}