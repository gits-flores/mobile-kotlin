package com.example.course_online.ui.PersonalGrowth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.topik.ModulesItem
import com.example.course_online.data.topik.ResponseListTopik
import com.example.course_online.network.ApiClient
import kotlinx.android.synthetic.main.activity_personal_growth.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonalGrowtActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var prefsManagers: PrefsManagers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_growth)

        prefsManagers = PrefsManagers(this)

        val idCourse = intent.getIntExtra("idCourse", 1)
        prefsManagers.prefsCourse = idCourse
        recyclerView = findViewById(R.id.rv_personal_growth)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getListTopik(idCourse)

        ic_back.setOnClickListener {
            onBackPressed()
        }

    }

    private fun getListTopik(id: Int) {
        val adapterTopik = AdapterPersonalGrowth(arrayListOf())
        recyclerView.adapter = adapterTopik

        ApiClient.endPoint.getListTopik(token = "Bearer ${prefsManagers.prefsToken}", id)
            .enqueue(object : Callback<ResponseListTopik>{
                override fun onResponse(
                    call: Call<ResponseListTopik>,
                    response: Response<ResponseListTopik>
                ) {
                    if (response.isSuccessful){
                        val course = response.body()
                        tv_course.text = course!!.title
                        tv_desc_course.text = course.description
                        if (course.modules?.size != 0){
                            adapterTopik.setData(course.modules as List<ModulesItem>)
                        }
                        else{
                            rv_personal_growth.visibility = GONE
                            ll_no_modul.visibility = VISIBLE
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseListTopik>, t: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "ERROR : ${t}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("ERROR LIST TOPIK", t.toString())
                }
            })
    }
}