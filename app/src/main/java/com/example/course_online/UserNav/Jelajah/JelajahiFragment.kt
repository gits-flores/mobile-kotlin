package com.example.course_online.UserNav.Jelajah

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.ui.Artikel.ArtikelActivity

class JelajahiFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var jelajahList: ArrayList<Jelajah>
    lateinit var IconID: Array<Int>
    lateinit var titleID: Array<String>
    lateinit var descID: Array<String>
    lateinit var btnID: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        IconID = arrayOf(
            R.drawable.ic_personal_growth,
            R.drawable.ic_romantic_relationships,
            R.drawable.ic_careers
        )
        titleID = arrayOf(
            "Artikel",
            "Survey",
            "Comin Soon"
        )
        descID = arrayOf(
            "Dapatkan tips, saran, dan wawasan mendalam tentang berbagai topik.",
            "Temukan bagaimana kepribadian Anda memengaruhi kebiasaan...",
            "Memahami arti dan dampak dari ciri-ciri kepribadian."
        )
        btnID = arrayOf(
            "BACA SEKARANG",
            "TES SEKARANG",
            "COMIN SOON"
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_jelajahi, container, false)
        recyclerView = view.findViewById(R.id.rv_jelajah)
        recyclerView.layoutManager = LinearLayoutManager(context)
        jelajahList = arrayListOf<Jelajah>()
//        recyclerView.adapter = JelajahAdapter(jelajahList)
        getJelajah()
        return view
    }

    private fun getJelajah() {
        for (i in IconID.indices) {
            val data = Jelajah(
                IconID[i], titleID[i], descID[i], btnID[i]
            )
            jelajahList.add(data)
        }
        val adapter = JelajahAdapter(jelajahList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : JelajahAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                startActivity(Intent(context, ArtikelActivity::class.java))
            }

        })

    }
}
