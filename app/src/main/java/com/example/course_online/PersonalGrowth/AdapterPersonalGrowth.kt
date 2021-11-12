package com.example.course_online.PersonalGrowth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R

class AdapterPersonalGrowth(private var listPersonal: ArrayList<PersonalGrowth>) :
    RecyclerView.Adapter<AdapterPersonalGrowth.myViewHolder>() {

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.img_materi)
        val imageSave: ImageView = itemView.findViewById(R.id.img_save)
        val judul: TextView = itemView.findViewById(R.id.tv_judul_module)
        val tim: TextView = itemView.findViewById(R.id.tv_tim_module)
        var status: TextView = itemView.findViewById(R.id.tv_status_module)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_personal_growth, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val item = listPersonal[position]
        holder.image.setImageResource(item.ImageMateri)
        holder.imageSave.setImageResource(item.ImageSave)
        holder.judul.text = item.Judul
        holder.tim.text = item.Tim
        holder.status.text = item.Status
    }

    override fun getItemCount() = listPersonal.size

}