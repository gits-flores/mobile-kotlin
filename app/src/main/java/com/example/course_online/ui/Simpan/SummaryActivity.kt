package com.example.course_online.ui.Simpan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.course_online.R
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.topik.ResponseListTopik
import com.example.course_online.network.ApiClient
import com.example.course_online.ui.PelajariTopik.PelajariTopikActivity
import kotlinx.android.synthetic.main.activity_congratulation.*
import kotlinx.android.synthetic.main.activity_summary.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SummaryActivity : AppCompatActivity() {

    lateinit var prefsManagers: PrefsManagers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        prefsManagers = PrefsManagers(this)

        getTopikRangkuman()

        ic_backSummary.setOnClickListener {
            onBackPressed()
        }

    }

    private fun getTopikRangkuman() {
        ApiClient.endPoint.getListCourse(token = "Bearer ${prefsManagers.prefsToken}")
            .enqueue(object : Callback<List<ResponseListTopik>> {
                override fun onResponse(
                    call: Call<List<ResponseListTopik>>,
                    response: Response<List<ResponseListTopik>>
                ) {
                    if(response.isSuccessful){
                        val course = response.body()!!.get(0)
                        val topik = prefsManagers.prefsModul
                        for (item in course.modules!!){
                            if (item!!.iD == topik){
                                tv_topikLearn.text = item.title
                                btn_ulangiTopik.setOnClickListener{
                                    val intent = Intent(applicationContext, PelajariTopikActivity::class.java)
                                        .putExtra("idCourse", item.courseId)
                                        .putExtra("idModul", item.iD)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                        for (item in response.body()!!){
                            if (item.iD == prefsManagers.prefsCourse){
                                tv_summary.text = item.rangkuman
                                tv_tagCourse.text = item.title
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