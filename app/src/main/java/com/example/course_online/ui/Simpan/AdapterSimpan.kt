package com.example.course_online.ui.Simpan

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class AdapterSimpan(childFragmentManager: FragmentManager)
    : FragmentPagerAdapter(childFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val simpanFragmentList  = ArrayList<Fragment>()
    private val simpanFragmentTitle = ArrayList<String>()

    override fun getCount() = simpanFragmentList.size

    override fun getItem(position: Int) : Fragment{
        return simpanFragmentList[position]
    }

    override fun getPageTitle(position: Int) : CharSequence?{
        return simpanFragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String){
        simpanFragmentList.add(fragment)
        simpanFragmentTitle.add(title)
    }
}