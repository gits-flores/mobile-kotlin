package com.example.course_online.UserNav.Profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.course_online.MainActivity
import com.example.course_online.R
import com.example.course_online.UserNav.Home.HomeFragment
import com.example.course_online.data.PrefsManagers
import com.example.course_online.ui.Profile.AboutAppsActivity
import com.example.course_online.ui.Profile.EditProfileActivity
import com.example.course_online.ui.SignInActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    lateinit var prefsManagers: PrefsManagers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        prefsManagers = PrefsManagers(container!!.context)
        setBtn(view)

        return view
    }


    private fun setBtn(view: View) {

        view.btn_editInfoUser.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }

        view.btn_setting_bahasa.setOnClickListener {
            Toast.makeText(activity,
                "Aplikasi hanya tersedia dalam bahasa Indonesia",
                Toast.LENGTH_SHORT).show()
        }

        view.rl_tentangApp.setOnClickListener {
            val intent = Intent(activity, AboutAppsActivity::class.java)
            startActivity(intent)
        }

        view.btn_logOut.setOnClickListener {
            prefsManagers.doLogout()
            val intent = Intent(activity, SignInActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
}