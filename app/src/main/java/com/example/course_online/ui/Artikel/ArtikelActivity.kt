package com.example.course_online.ui.Artikel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.data.artikel.DataListArtikelItem
import com.example.course_online.network.ApiClient
import com.example.course_online.ui.DetailArtikelActivity
import com.example.course_online.ui.PersonalGrowth.PersonalGrowth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtikelActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterArtikel: AdapterArtikel
    lateinit var prefsManagers: PrefsManagers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        prefsManagers = PrefsManagers(this)

        recyclerView = findViewById(R.id.rv_artikel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getArtikel()
    }

    private fun getArtikel() {
        val adapterArtikel = AdapterArtikel(arrayListOf())
        recyclerView.adapter = adapterArtikel

        ApiClient.endPoint.getListArtikel(token = "Bearer ${prefsManagers.prefsToken}")
            .enqueue(object : Callback<DataListArtikel>{
                override fun onResponse(
                    call: Call<DataListArtikel>,
                    response: Response<DataListArtikel>
                ) {
                    if (response.isSuccessful){
                        getArtikelList(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<DataListArtikel>, t: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "ERROR : ${t}",
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.e("ERROR ARTIKEL", t.toString())
                }

            })

        adapterArtikel.setOnItemClickListener(object : AdapterArtikel.onItemClickListener{
            override fun onItemClick(position: Int) {
                startActivity(Intent(this@ArtikelActivity, DetailArtikelActivity::class.java))
            }

        })
    }

    private fun getArtikelList(response: DataListArtikel) {
        val data = response.dataListArtikel
        adapterArtikel.setData(data as List<DataListArtikelItem>)
    }
}