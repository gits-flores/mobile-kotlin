package com.example.course_online.ui.Artikel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.data.artikel.DataListArtikelItem
import com.squareup.picasso.Picasso

class AdapterArtikel(private var listArtikel: ArrayList<DataListArtikelItem>) :
    RecyclerView.Adapter<AdapterArtikel.myViewHolder>() {
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener

    }

    fun setData(result: List<DataListArtikelItem>){
        listArtikel.clear()
        listArtikel.addAll(result)
        notifyDataSetChanged()
    }

    class myViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val image: ImageView = itemView.findViewById(R.id.img_artikel)
        val imageSave: ImageView = itemView.findViewById(R.id.img_save)
        val judul: TextView = itemView.findViewById(R.id.tv_judul_artikel)
        val tim: TextView = itemView.findViewById(R.id.tv_author)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artikel, parent, false)
        return myViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val item = listArtikel[position]
        val thumbnailImageUrl = "echo.alghiffaryenterprise.id/public/uploads/{${item.thumbnail}}"
        holder.judul.text = item.title
        Picasso.get().load(thumbnailImageUrl).fit().centerCrop().into(holder.image)
        holder.tim.text = "Tim Personality"
    }

    override fun getItemCount() = listArtikel.size
}