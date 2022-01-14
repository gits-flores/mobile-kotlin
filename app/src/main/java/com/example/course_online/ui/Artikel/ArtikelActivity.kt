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
//import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.network.ApiClient
import com.example.course_online.ui.DetailArtikelActivity
import kotlinx.android.synthetic.main.activity_artikel.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtikelActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var prefsManagers: PrefsManagers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        prefsManagers = PrefsManagers(this)

        recyclerView = findViewById(R.id.rv_artikel)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getArtikel()
        backBtn()

    }

    private fun backBtn() {
        iv_back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getArtikel() {
        prefsManagers = PrefsManagers(this)
        val adapterArtikel = AdapterArtikel(arrayListOf(), prefsManagers)
        recyclerView.adapter = adapterArtikel

        ApiClient.endPoint.getListArtikel(token = "Bearer ${prefsManagers.prefsToken}")
            .enqueue(object : Callback<List<DataListArtikel>>{
                override fun onResponse(
                    call: Call<List<DataListArtikel>>,
                    response: Response<List<DataListArtikel>>
                ) {
                    if(response.isSuccessful){
                        val artikel = response.body()!!
                        adapterArtikel.setData(artikel)
                    }
                }

                override fun onFailure(call: Call<List<DataListArtikel>>, t: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "ERROR : ${t}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("ERROR ARTIKEL", t.toString())
                }

            })
    }
}