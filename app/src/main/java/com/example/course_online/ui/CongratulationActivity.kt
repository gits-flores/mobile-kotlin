package com.example.course_online.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.course_online.R
import com.example.course_online.ui.Simpan.SummaryActivity
import kotlinx.android.synthetic.main.activity_congratulation.*

class CongratulationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulation)

        btn_pelajari.setOnClickListener {
            startActivity(Intent(this, SummaryActivity::class.java))
        }
    }
}