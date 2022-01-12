package com.example.course_online.UserNav.Simpan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.ui.Simpan.Topik.AdapterTopik
import com.example.course_online.ui.Simpan.Topik.Topik

class TopikFragment : Fragment() {

    private lateinit var topikRecyclerView: RecyclerView
    private lateinit var listSavedTopik: ArrayList<Topik>
    lateinit var imageID: Array<Int>
    lateinit var imageSaveID: Array<Int>
    lateinit var judulID: Array<String>
    lateinit var timID: Array<String>
    lateinit var statusID: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageID = arrayOf(
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_one
        )
        imageSaveID = arrayOf(
            R.drawable.ic_unsave,
            R.drawable.ic_unsave,
            R.drawable.ic_unsave
        )
        judulID = arrayOf(
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda"
        )
        timID = arrayOf(
            "Tim Personality",
            "Tim Personality",
            "Tim Personality"
        )
        statusID = arrayOf(
            "MULAI",
            "SELESAI",
            "LANJUTKAN"
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_topik, container, false)

        setUpRecycleView(view)

        return view
    }

    private fun setUpRecycleView(view: View) {
        topikRecyclerView = view.findViewById(R.id.rv_topik)
        topikRecyclerView.layoutManager = LinearLayoutManager(activity)
        listSavedTopik = arrayListOf<Topik>()
        topikRecyclerView.adapter = AdapterTopik(listSavedTopik)
        getSavedTopik()
    }

    private fun getSavedTopik() {
        for (i in imageID.indices) {
            val data = Topik(
                imageID[i],
                imageSaveID[i],
                judulID[i],
                timID[i],
                statusID[i]
            )
            listSavedTopik.add(data)
        }
    }

}