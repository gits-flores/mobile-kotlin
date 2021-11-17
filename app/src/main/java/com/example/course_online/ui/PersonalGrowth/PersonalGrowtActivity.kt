package com.example.course_online.ui.PersonalGrowth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R

class PersonalGrowtActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var personalList: ArrayList<PersonalGrowth>
    lateinit var imageID: Array<Int>
    lateinit var imageSaveID: Array<Int>
    lateinit var judulID: Array<String>
    lateinit var timID: Array<String>
    lateinit var statusID: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persoanl_growt)

        imageID = arrayOf(
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_two,
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_two
        )
        imageSaveID = arrayOf(
            R.drawable.ic_save,
            R.drawable.ic_save,
            R.drawable.ic_save,
            R.drawable.ic_save,
        )
        judulID = arrayOf(
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda"
        )
        timID = arrayOf(
            "Tim Personality",
            "Tim Personality",
            "Tim Personality",
            "Tim Personality",
        )
        statusID = arrayOf(
            "MULAI",
            "SELESAI",
            "MULAI",
            "SELESAI",
        )
        recyclerView = findViewById(R.id.rv_personal_growth)
        recyclerView.layoutManager = LinearLayoutManager(this)
        personalList = arrayListOf<PersonalGrowth>()
        recyclerView.adapter = AdapterPersonalGrowth(personalList)
        getPersonal()
    }

    private fun getPersonal() {
        for (i in imageID.indices) {
            val data = PersonalGrowth(imageID[i], imageSaveID[i], judulID[i], timID[i], statusID[i])
            personalList.add(data)
        }
    }
}