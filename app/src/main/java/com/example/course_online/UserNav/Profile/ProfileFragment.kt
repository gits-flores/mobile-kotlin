package com.example.course_online.UserNav.Profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.course_online.MainActivity
import com.example.course_online.R
import com.example.course_online.UserNav.Home.HomeFragment
import com.example.course_online.ui.Profile.AboutAppsActivity
import com.example.course_online.ui.Profile.EditProfileActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    private lateinit var editBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        setBtn(view)

        return view
    }


    private fun setBtn(view: View) {

        view.btn_editInfoUser.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }

        view.rl_tentangApp.setOnClickListener {
            val intent = Intent(activity, AboutAppsActivity::class.java)
            startActivity(intent)
        }

    }
}