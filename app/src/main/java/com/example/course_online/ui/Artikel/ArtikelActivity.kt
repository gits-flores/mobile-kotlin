package com.example.course_online.ui.Artikel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.ui.PersonalGrowth.PersonalGrowth

class ArtikelActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var artikellList: ArrayList<Artikel>
    lateinit var iconID: Array<Int>
    lateinit var saveID: Array<Int>
    lateinit var titleID: Array<String>
    lateinit var timID: Array<String>
    lateinit var statusID: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        iconID = arrayOf(
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_one,
        )
        saveID = arrayOf(
            R.drawable.ic_save,
            R.drawable.ic_save,
            R.drawable.ic_save,
            R.drawable.ic_save,
        )
        titleID = arrayOf(
            "Personality Types vs. Stereotypes",
            "Saya Sangat Tidak Suka Orang Ini. Apakah Karena Tipe Kepribadian Mereka?",
            "Lebih Baik Menjadi Introvert atau Ekstrovert?",
            "Lebih Baik Menjadi Introvert atau Ekstrovert?",
        )
        timID = arrayOf(
            "Deni Alfian",
            "Deni Alfian",
            "Deni Alfian",
            "Deni Alfian",
        )
        statusID = arrayOf(
            "LIHAT",
            "LIHAT",
            "LIHAT",
            "LIHAT",
        )
        recyclerView = findViewById(R.id.rv_artikel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        artikellList = arrayListOf<Artikel>()
        recyclerView.adapter = AdapterArtikel(artikellList)
        getArtikel()
    }

    private fun getArtikel() {
        for (i in iconID.indices) {
            val data = Artikel(iconID[i], saveID[i], titleID[i], timID[i], statusID[i])
            artikellList.add(data)
        }
    }
}