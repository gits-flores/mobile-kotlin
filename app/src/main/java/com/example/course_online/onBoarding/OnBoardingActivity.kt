package com.example.course_online.onBoarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.course_online.R
import com.example.course_online.login_register.SignInActivity
import com.google.android.material.tabs.TabLayout

class OnBoardingActivity : AppCompatActivity() {

    var onBoardingViewPagerAdapter: ViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager: ViewPager? = null
    var next: TextView? = null
    var position = 0
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boaerding)
        supportActionBar?.hide()

        if (restorePrefData()) {
            val intent = Intent(applicationContext, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

        tabLayout = findViewById(R.id.tab_pager)
        next = findViewById(R.id.tv_next)
        val onBoardingData: MutableList<OnBoardingData> = arrayListOf()
        onBoardingData.add(
            OnBoardingData(
                "Page One",
                "Description of page one",
                R.drawable.blank_image
            )
        )
        onBoardingData.add(
            OnBoardingData(
                "Page Two",
                "Description of page two",
                R.drawable.blank_image
            )
        )
        onBoardingData.add(
            OnBoardingData(
                "Page Three",
                "Description of page three",
                R.drawable.blank_image
            )
        )
        setOnBoardingViewPagerAdapter(onBoardingData)
        position = onBoardingViewPager!!.currentItem

        next?.setOnClickListener {
            if (position < onBoardingData.size) {
                position++
                onBoardingViewPager!!.currentItem = position
            }
            if (position == onBoardingData.size){
                savePrefData()
                val intent = Intent(applicationContext, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                position = tab!!.position
                if (tab.position == onBoardingData.size - 1) {
                    next!!.text = "Get Started"
                } else {
                    next!!.text = "Next"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>) {
        onBoardingViewPager = findViewById(R.id.screenPager)
        onBoardingViewPagerAdapter = ViewPagerAdapter(this, onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }

    private fun savePrefData() {
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    private fun restorePrefData(): Boolean {
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)
    }
}