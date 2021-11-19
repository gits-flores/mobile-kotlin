package com.example.course_online.UserNav.Simpan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.course_online.R
import com.example.course_online.ui.Simpan.AdapterSimpan
import com.google.android.material.tabs.TabLayout


class SimpanFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabsSimpan : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setUpTabs() {

        val adapterSimpan = AdapterSimpan(childFragmentManager)

        adapterSimpan.addFragment(TopikFragment(), "Topik")
        adapterSimpan.addFragment(ArtikelFragment(), "Artikel")
        adapterSimpan.addFragment(SurveyFragment(), "Survey")

        viewPager.adapter = adapterSimpan
        tabsSimpan.setupWithViewPager(viewPager)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_simpan, container, false)
        viewPager = view.findViewById(R.id.simpanViewPager) as ViewPager
        tabsSimpan = view.findViewById(R.id.tabs_simpan)

        setUpTabs()

        return view
    }

}
