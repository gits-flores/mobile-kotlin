package com.example.course_online.ui.PelajariTopik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R

class AdapterTopik(private var listTopik : List<Topik>)
    : RecyclerView.Adapter<AdapterTopik.myViewHolder>(){

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.iv_ilustrasiTopik)
        val judul : TextView = itemView.findViewById(R.id.tv_isiTopik4)
        val isi : TextView = itemView.findViewById(R.id.tv_isiTopik5)

        fun bind(get: Topik){
            image.setImageResource(get.imageTopik)
            judul.text = get.judulTopik
            isi.text = get.isiTopik
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTopik.myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_topik, parent, false)
        return  myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterTopik.myViewHolder, position: Int) {
        holder.bind(listTopik[position])
    }

    override fun getItemCount() = listTopik.size
}