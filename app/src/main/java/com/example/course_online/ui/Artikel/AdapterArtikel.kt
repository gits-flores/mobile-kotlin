package com.example.course_online.ui.Artikel

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.ui.DetailArtikelActivity
import com.squareup.picasso.Picasso

class AdapterArtikel(private var listArtikel: ArrayList<DataListArtikel>) :
    RecyclerView.Adapter<AdapterArtikel.myViewHolder>() {

    fun setData(result: List<DataListArtikel>){
        listArtikel.clear()
        listArtikel.addAll(result)
        notifyDataSetChanged()
    }

    inner class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rv_artikel: RelativeLayout = itemView.findViewById(R.id.rv_item_artikel)
        val read_artikel: TextView = itemView.findViewById(R.id.tv_read_artikel)
        val image: ImageView = itemView.findViewById(R.id.img_artikel)
        val imageSave: ImageView = itemView.findViewById(R.id.img_save)
        val judul: TextView = itemView.findViewById(R.id.tv_judul_artikel)
        val tim: TextView = itemView.findViewById(R.id.tv_author)

        fun bind(get: DataListArtikel) {
            val idArtikel = get.iD
            val thumbnailImageUrl = "echo.alghiffaryenterprise.id/uploads/{${get.thumbnail}}"
            judul.text = get.title
            tim.text = get.user!!.name
            image.setImageResource(R.drawable.ic_poll)

            rv_artikel.setOnClickListener {
                val intent = Intent(itemView.context, DetailArtikelActivity::class.java)
                    .putExtra("idArtikel", idArtikel)
                itemView.context.startActivity(intent)
            }

            read_artikel.setOnClickListener {
                val intent = Intent(itemView.context, DetailArtikelActivity::class.java)
                    .putExtra("idArtikel", idArtikel)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artikel, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(listArtikel[position])
    }

    override fun getItemCount() = listArtikel.size
}