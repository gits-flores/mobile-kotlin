package com.example.course_online.ui.PelajariTopik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.course_online.databinding.ActivityPelajariTopikBinding
import com.example.course_online.ui.CongratulationActivity
import com.example.course_online.ui.PersonalGrowth.PersonalGrowtActivity
import kotlinx.android.synthetic.main.activity_pelajari_topik.*


class PelajariTopikActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPelajariTopikBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPelajariTopikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTopikViewPager()
        setUpDrawer()

        binding.icBackBtn.setOnClickListener {
            val intent = Intent(this, PersonalGrowtActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun setUpDrawer() {

        binding.drawer.setOnDrawerOpenListener{
            binding.CardTopikViewpager.translationX = -(binding.contentDrawer.width.toFloat())

            binding.btnSelesaiPelajari.setOnClickListener {
                val intent = Intent(this, CongratulationActivity::class.java)
                startActivity(intent)
            }

        }
        binding.drawer.setOnDrawerCloseListener {
            binding.CardTopikViewpager.translationX = 0f
        }

    }

    private fun setUpTopikViewPager() {
        binding.CardTopikViewpager.adapter = AdapterTopik(listOfTopik())
        binding.CardTopikViewpager.offscreenPageLimit = 3
        binding.CardTopikViewpager.setPageTransformer(CardSlider())
    }
}
