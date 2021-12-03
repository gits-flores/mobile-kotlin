package com.example.course_online.ui.PelajariTopik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.course_online.R
import com.example.course_online.databinding.ActivityEditProfileBinding
import com.example.course_online.databinding.ActivityPelajariTopikBinding

class PelajariTopikActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPelajariTopikBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPelajariTopikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.CardTopikViewpager.apply {
            adapter = AdapterTopik(listOfTopik())
            offscreenPageLimit = 4
            setPageTransformer(CardSlider(4))
        }

    }
}