package com.example.course_online.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.course_online.R
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.artikel.ResponseDetailArtikel
import com.example.course_online.network.ApiClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_artikel.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailArtikelActivity : AppCompatActivity() {

    lateinit var prefsManagers: PrefsManagers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artikel)

        prefsManagers = PrefsManagers(this)

        val idArtikelDetail = intent.getIntExtra("idArtikel", 1)

        Log.i("ID ARTIKEL", idArtikelDetail.toString())

        getDetailArtikel(idArtikelDetail)
    }

    private fun getDetailArtikel(idArtikel : Int) {
        ApiClient.endPoint.getDetailArtikel(token = "Bearer ${prefsManagers.prefsToken}",idArtikel)
            .enqueue(object : Callback <ResponseDetailArtikel>{
                override fun onResponse(
                    call: Call<ResponseDetailArtikel>,
                    response: Response<ResponseDetailArtikel>
                ) {
                    if (response.isSuccessful){
                        val artikel = response.body()
                        val date = artikel!!.createdAt!!.substringBefore("T")
                        val thumbnailUri = "echo.alghiffaryenterprise.id/uploads/{${artikel!!.thumbnail}}"
                        Picasso.get().load(thumbnailUri)
                            .fit()
                            .placeholder(R.drawable.ic_detail_artikel)
                            .into(ivDetailArtikel)
                        tv_judulDetailArtikel.text = artikel.title
                        tv_author.text = artikel.author!!.name
                        tvTime.text = date
                        tvIsiArtikel.text = artikel.content
                    }
                }

                override fun onFailure(call: Call<ResponseDetailArtikel>, t: Throwable) {
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