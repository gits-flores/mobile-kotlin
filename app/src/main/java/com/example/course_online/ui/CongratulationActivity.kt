package com.example.course_online.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.course_online.R
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.topik.ResponseListTopik
import com.example.course_online.network.ApiClient
import com.example.course_online.ui.PelajariTopik.Topik
import com.example.course_online.ui.PersonalGrowth.PersonalGrowtActivity
import com.example.course_online.ui.Simpan.SummaryActivity
import kotlinx.android.synthetic.main.activity_congratulation.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CongratulationActivity : AppCompatActivity() {

    lateinit var prefsManagers: PrefsManagers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulation)

        prefsManagers = PrefsManagers(this)

        getNextTopik()

        tv_bacaRangkuman.setOnClickListener {
            startActivity(Intent(this, SummaryActivity::class.java))
        }

        btn_pelajari.setOnClickListener {
            startActivity(Intent(this, PersonalGrowtActivity::class.java))
        }

        ic_back.setOnClickListener {
            onBackPressed()
        }

    }

    private fun getNextTopik() {
        ApiClient.endPoint.getListCourse(token = "Bearer ${prefsManagers.prefsToken}")
            .enqueue(object : Callback<List<ResponseListTopik>>{
                override fun onResponse(
                    call: Call<List<ResponseListTopik>>,
                    response: Response<List<ResponseListTopik>>
                ) {
                    if(response.isSuccessful){
                        val course = response.body()!!.get(0)
                        val nextTopik = prefsManagers.prefsModul + 1
                        var maxTopik = 0
                        for (item in course.modules!!){
                            if (item!!.iD == nextTopik){
                                tv_nextTopik.text = item.title
                            }
                            else if( nextTopik > course.modules.size){
                                tv_nextTopik.text = "Selamat Kamu Telah Mempelajari Semua Topik " + course.title
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<ResponseListTopik>>, t: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "ERROR : ${t}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("ERROR NEXT TOPIK", t.toString())
                }

            })
    }
}