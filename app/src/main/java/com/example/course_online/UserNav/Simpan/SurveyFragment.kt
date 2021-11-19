package com.example.course_online.UserNav.Simpan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.ui.Simpan.Artikel.AdapterArtikel
import com.example.course_online.ui.Simpan.Artikel.Artikel
import com.example.course_online.ui.Simpan.Survey.AdapterSurvey
import com.example.course_online.ui.Simpan.Survey.Survey

class SurveyFragment : Fragment() {

    private lateinit var surveyRecyclerView: RecyclerView
    private lateinit var listSavedSurvey: ArrayList<Survey>
    lateinit var imageID: Array<Int>
    lateinit var judulID: Array<String>
    lateinit var authorID: Array<String>
    lateinit var imageSaveID: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageID = arrayOf(
            R.drawable.ic_poll,
            R.drawable.ic_poll
        )
        imageSaveID = arrayOf(
            R.drawable.ic_save,
            R.drawable.ic_save,
        )
        judulID = arrayOf(
            "Sifat dan Kebiasaan",
            "Sifat dan Kebiasaan"
        )
        authorID = arrayOf(
            "Oleh Tim Personality",
            "Oleh Tim Personality"
        )


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_survey, container, false)

        setUpRecycleView(view)

        return view
    }

    private fun setUpRecycleView(view: View) {

        surveyRecyclerView = view.findViewById(R.id.rv_survey)
        surveyRecyclerView.layoutManager = LinearLayoutManager(activity)
        listSavedSurvey = arrayListOf<Survey>()
        surveyRecyclerView.adapter = AdapterSurvey(listSavedSurvey)
        getSavedSurvey()

    }

    private fun getSavedSurvey() {
        for (i in imageID.indices){
            val data = Survey(
                imageID[i],
                imageSaveID[i],
                judulID[i],
                authorID[i],
            )
            listSavedSurvey.add(data)
        }
    }
}