package com.example.course_online.ui.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.course_online.MainActivity
import com.example.course_online.R
import com.example.course_online.UserNav.Profile.ProfileFragment
import com.example.course_online.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        setGenderList()
    }

    private fun setGenderList() {
        val gender = resources.getStringArray(R.array.Gender)
        val genderArrAdapter = ArrayAdapter(this, R.layout.gender_item, gender)
        binding.setGender.setAdapter(genderArrAdapter)
    }
}