package com.example.course_online.ui.Simpan

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.course_online.UserNav.Simpan.ArtikelFragment
import com.example.course_online.UserNav.Simpan.SurveyFragment
import com.example.course_online.UserNav.Simpan.TopikFragment

class AdapterSimpan(childFragmentManager: FragmentManager) :
    FragmentPagerAdapter(childFragmentManager) {
    private val simpanFragmentList = ArrayList<Fragment>()
    private val simpanFragmentTitle = ArrayList<String>()
    override fun getCount() = simpanFragmentList.size


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TopikFragment()
            }
            1 -> {
                ArtikelFragment()
            }
            2 -> {
                SurveyFragment()
            }
            else -> getItem(position)
        }
//        return simpanFragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return simpanFragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        simpanFragmentList.add(fragment)
        simpanFragmentTitle.add(title)
    }

}