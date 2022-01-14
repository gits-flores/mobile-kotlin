package com.example.course_online.ui.PelajariTopik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.core.graphics.alpha
import com.example.course_online.R
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.topik.ModulesItem
import com.example.course_online.data.topik.ResponseListTopik
import com.example.course_online.databinding.ActivityPelajariTopikBinding
import com.example.course_online.network.ApiClient
import com.example.course_online.ui.CongratulationActivity
import kotlinx.android.synthetic.main.activity_pelajari_topik.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PelajariTopikActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPelajariTopikBinding
    lateinit var prefsManagers: PrefsManagers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefsManagers = PrefsManagers(this)

        prefsManagers.prefsModul = intent.getIntExtra("idModul",2)
        prefsManagers.prefsCourse = intent.getIntExtra("idCourse", 1)

        binding = ActivityPelajariTopikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTopikViewPager()
        setUpDrawer()

        binding.icBackBtn.setOnClickListener {
            onBackPressed()
            finish()
        }
    }

    private fun setUpDrawer() {
        binding.drawer.setOnDragListener { view, dragEvent ->
            when(dragEvent.action){
                DragEvent.ACTION_DRAG_STARTED -> {
                    binding.handler.rotation = 90F
                    binding.handler.setPadding(0, 0, 18, 0)
                true
                }
                else -> {
                    bg_drawer.visibility = GONE
                    binding.handler.rotation = 270F
                    binding.handler.setPadding(18, 0, 0, 0)
                    false
                }
            }
        }

        binding.drawer.setOnDrawerOpenListener{
            bg_drawer.visibility = VISIBLE
            binding.handler.rotation = 90F
            binding.handler.setPadding(0, 0, 18, 0)
            binding.btnSelesaiPelajari.setOnClickListener {
                val intent = Intent(this, CongratulationActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        binding.drawer.setOnDrawerCloseListener {
            binding.handler.rotation = 270F
            binding.handler.setPadding(18, 0, 0, 0)
            bg_drawer.visibility = GONE
        }

    }

    override fun onBackPressed() {
        if (binding.drawer.isOpened){
            binding.drawer.animateClose()
            binding.handler.rotation = 270F
            binding.handler.setPadding(18, 0, 0, 0)
        }
        else{
            super.onBackPressed()
        }
    }

    private fun setUpTopikViewPager() {
        val adapterModul = AdapterTopik(arrayListOf())
        binding.CardTopikViewpager.adapter = adapterModul
        binding.CardTopikViewpager.offscreenPageLimit = 3
        binding.CardTopikViewpager.setPageTransformer(CardSlider())

        val idCourse = prefsManagers.prefsCourse
        ApiClient.endPoint.getListTopik(token = "Bearer ${prefsManagers.prefsToken}", idCourse)
            .enqueue(object : Callback<ResponseListTopik>{
                override fun onResponse(
                    call: Call<ResponseListTopik>,
                    response: Response<ResponseListTopik>
                ) {
                    if (response.isSuccessful){
                        val course = response.body()
                        adapterModul.setData(course!!.modules as List<ModulesItem>)
                    }
                }
                override fun onFailure(call: Call<ResponseListTopik>, t: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "ERROR : ${t}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("ERROR MODULE", t.toString())
                }
            })
    }

}
