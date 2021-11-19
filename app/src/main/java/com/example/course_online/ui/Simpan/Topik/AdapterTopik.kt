package com.example.course_online.ui.Simpan.Topik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R

class AdapterTopik(private var  listSavedTopik: ArrayList<Topik>)
    : RecyclerView.Adapter<AdapterTopik.myViewHolder>()  {

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.img_materi)
        val imageSave: ImageView = itemView.findViewById(R.id.img_save)
        val judul: TextView = itemView.findViewById(R.id.tv_judul_module)
        val tim: TextView = itemView.findViewById(R.id.tv_tim_module)
        var status: TextView = itemView.findViewById(R.id.tv_status_module)

        fun bind(get: Topik) {
            image.setImageResource(get.ImageMateri)
            imageSave.setImageResource(get.ImageSave)
            judul.text = get.Judul
            tim.text = get.Tim
            status.text = get.Status
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTopik.myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topik, parent, false)
        return AdapterTopik.myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterTopik.myViewHolder, position: Int) {
        holder.bind(listSavedTopik[position])
    }

    override fun getItemCount() = listSavedTopik.size
}