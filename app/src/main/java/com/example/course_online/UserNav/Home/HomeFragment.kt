package com.example.course_online.UserNav.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R

class HomeFragment : Fragment() {
    private lateinit var modulRecyclerView: RecyclerView
    private lateinit var listModul: ArrayList<ModulPilihan>
    private lateinit var pelajariBtn : Button
    lateinit var imageID: Array<Int>
    lateinit var judulID: Array<String>
    lateinit var descID: Array<String>
    lateinit var progressID: Array<Int>
    lateinit var maxTopicID: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageID = arrayOf(
            R.drawable.ic_personal_growth,
            R.drawable.ic_romantic_relationships,
            R.drawable.ic_careers
        )

        judulID = arrayOf(
            "Personal Growth",
            "Relationship",
            "Careers"
        )

        descID = arrayOf(
            "Temukan serta pahami kekuatan dan kelemahan",
            "Perdalam hubungan anda bersama orang lain",
            "Menjadi lebih baik dalam merencanakan tujuan"
        )

        progressID = arrayOf(
            0,
            0,
            0
        )

        maxTopicID = arrayOf(
            20,
            10,
            15
        )
    }

    private fun getModul() {
        for (i in imageID.indices){
            val data = ModulPilihan(
                imageID[i],
                judulID[i],
                descID[i],
                progressID[i],
                maxTopicID[i]
            )
            listModul.add(data)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        modulRecyclerView = view.findViewById(R.id.recycleviewModul)
        modulRecyclerView.layoutManager = LinearLayoutManager(activity)
        listModul = arrayListOf<ModulPilihan>()
        modulRecyclerView.adapter = AdapterModulPilihan(listModul)
        getModul()

        return view
    }
}