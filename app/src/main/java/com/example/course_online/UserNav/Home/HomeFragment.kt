package com.example.course_online.UserNav.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.topik.ResponseListTopik
import com.example.course_online.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var modulRecyclerView: RecyclerView
    lateinit var prefsManagers: PrefsManagers

    private fun getModul() {
        val adapterCourse = AdapterModulPilihan(arrayListOf())
        modulRecyclerView.adapter = adapterCourse

        ApiClient.endPoint.getListCourse(token = "Bearer ${prefsManagers.prefsToken}")
            .enqueue(object : Callback<List<ResponseListTopik>>{
                override fun onResponse(
                    call: Call<List<ResponseListTopik>>,
                    response: Response<List<ResponseListTopik>>
                ) {
                    if (response.isSuccessful){
                        val course = response.body()
                        adapterCourse.setData(course!!)
                    }
                }

                override fun onFailure(call: Call<List<ResponseListTopik>>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "ERROR : ${t}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("ERROR COURSE", t.toString())
                }

            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        prefsManagers = PrefsManagers(view.context)
        modulRecyclerView = view.findViewById(R.id.recycleviewModul)
        modulRecyclerView.layoutManager = LinearLayoutManager(activity)

        getModul()

        return view
    }
}