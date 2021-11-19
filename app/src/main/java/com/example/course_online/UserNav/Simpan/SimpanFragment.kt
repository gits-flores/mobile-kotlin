package com.example.course_online.UserNav.Simpan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.course_online.R
import com.example.course_online.ui.Simpan.AdapterSimpan
import com.example.course_online.ui.onBoarding.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_simpan.*
import kotlinx.android.synthetic.main.fragment_simpan.view.*


class SimpanFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabsSimpan : TabLayout

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun setUpTabs(view: View) {

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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_simpan, container, false)
        viewPager = view.findViewById(R.id.simpanViewPager) as ViewPager
        tabsSimpan = view.findViewById(R.id.tabs_simpan)

        setUpTabs(view)

        return view
    }

}
