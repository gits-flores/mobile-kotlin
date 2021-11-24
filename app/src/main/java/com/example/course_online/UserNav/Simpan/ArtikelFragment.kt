package com.example.course_online.UserNav.Simpan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.UserNav.Home.AdapterModulPilihan
import com.example.course_online.UserNav.Home.ModulPilihan
import com.example.course_online.ui.Simpan.Artikel.AdapterArtikel
import com.example.course_online.ui.Simpan.Artikel.Artikel

class ArtikelFragment : Fragment() {

    private lateinit var artikelRecyclerView: RecyclerView
    private lateinit var listSavedArtikel: ArrayList<Artikel>
    lateinit var imageID: Array<Int>
    lateinit var judulID: Array<String>
    lateinit var authorID: Array<String>
    lateinit var imageSaveID: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageID = arrayOf(
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_one,
            R.drawable.ic_pg_one
        )
        imageSaveID = arrayOf(
            R.drawable.ic_save,
            R.drawable.ic_save,
            R.drawable.ic_save
        )
        judulID = arrayOf(
            "Personality Types vs. Stereotypes",
            "Personality Types vs. Stereotypes",
            "Personality Types vs. Stereotypes"
        )
        authorID = arrayOf(
            "Oleh Deni Alfian",
            "Oleh Deni Alfian",
            "Oleh Deni Alfian"
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_artikel, container, false)

        setUpRecycleView(view)

        return view
    }

    private fun setUpRecycleView(view: View) {
        artikelRecyclerView = view.findViewById(R.id.rv_artikel)
        artikelRecyclerView.layoutManager = LinearLayoutManager(activity)
        listSavedArtikel = arrayListOf<Artikel>()
        artikelRecyclerView.adapter = AdapterArtikel(listSavedArtikel)
        getSavedArtikel()
    }

    private fun getSavedArtikel() {
        for (i in imageID.indices){
            val data = Artikel(
                imageID[i],
                imageSaveID[i],
                judulID[i],
                authorID[i],
            )
            listSavedArtikel.add(data)
        }
    }

}