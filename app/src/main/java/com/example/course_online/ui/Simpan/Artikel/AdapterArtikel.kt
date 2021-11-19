package com.example.course_online.ui.Simpan.Artikel

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R

class AdapterArtikel(private var  listSavedArtikel: ArrayList<Artikel>)
    : RecyclerView.Adapter<AdapterArtikel.myViewHolder>() {

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.img_artikel)
        val judul: TextView = itemView.findViewById(R.id.tv_judul_artikel)
        val author: TextView = itemView.findViewById(R.id.tv_author)
        val BacaBtn: TextView = itemView.findViewById(R.id.tv_read)
        val imageSave: ImageView = itemView.findViewById(R.id.img_save)

        fun bind(get: Artikel) {
            image.setImageResource(get.ImageArtikel)
            imageSave.setImageResource(get.ImageSave)
            judul.text = get.Judul
            author.text = get.Author
            BacaBtn.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artikel, parent, false)
        return AdapterArtikel.myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterArtikel.myViewHolder, position: Int) {
        holder.bind(listSavedArtikel[position])
    }

    override fun getItemCount() = listSavedArtikel.size
}