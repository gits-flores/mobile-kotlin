package com.example.course_online.UserNav.Simpan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.DataSaveArticle
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.network.ApiClient
import com.example.course_online.ui.Simpan.Artikel.AdapterArtikel
import com.example.course_online.ui.Simpan.Artikel.Artikel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtikelFragment : Fragment() {

    lateinit var prefsManagers: PrefsManagers
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_artikel, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefsManagers = context?.let { PrefsManagers(it) }!!
        recyclerView = view.findViewById(R.id.rv_artikel_save)
        recyclerView.layoutManager = LinearLayoutManager(context)
        getArtikelSave()
    }

    private fun getArtikelSave() {
        val adapterArtikelSave = AdapterArtikel(arrayListOf(), prefsManagers)
        recyclerView.adapter = adapterArtikelSave

        ApiClient.endPoint.getSaveArticles(token = "Bearer ${prefsManagers.prefsToken}", "3")
            .enqueue(object : Callback<List<DataSaveArticle>> {
                override fun onResponse(
                    call: Call<List<DataSaveArticle>>,
                    response: Response<List<DataSaveArticle>>
                ) {
                    if (response.isSuccessful) {
                        val artikelSave = response.body()
                        adapterArtikelSave.setData(artikelSave!!)
                        onStart()
                    }
                }

                override fun onFailure(call: Call<List<DataSaveArticle>>, t: Throwable) {
                    Toast.makeText(context, "$t", Toast.LENGTH_SHORT).show()
                }

            })
    }

}