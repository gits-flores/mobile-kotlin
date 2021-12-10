package com.example.course_online.ui.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.course_online.MainActivity
import com.example.course_online.R
import com.example.course_online.databinding.ActivityAboutAppsBinding

class AboutAppsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAboutAppsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutAppsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}