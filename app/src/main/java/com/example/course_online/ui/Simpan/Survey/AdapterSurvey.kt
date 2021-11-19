package com.example.course_online.ui.Simpan.Survey

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R

class AdapterSurvey (private var  listSavedSurvey: ArrayList<Survey>)
    : RecyclerView.Adapter<AdapterSurvey.myViewHolder>()  {

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.img_survey)
        val judul: TextView = itemView.findViewById(R.id.tv_judul_survey)
        val author: TextView = itemView.findViewById(R.id.tv_author)
        val CobaBtn: TextView = itemView.findViewById(R.id.tv_coba)
        val imageSave: ImageView = itemView.findViewById(R.id.img_save)

        fun bind(get: Survey) {
            image.setImageResource(get.ImageSurvey)
            imageSave.setImageResource(get.ImageSave)
            judul.text = get.Judul
            author.text = get.Author
            CobaBtn.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterSurvey.myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_survey, parent, false)
        return AdapterSurvey.myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterSurvey.myViewHolder, position: Int) {
        holder.bind(listSavedSurvey[position])
    }

    override fun getItemCount() = listSavedSurvey.size
}