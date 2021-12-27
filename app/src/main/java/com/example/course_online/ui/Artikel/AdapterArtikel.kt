package com.example.course_online.ui.Artikel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.artikel.DataListArtikel
import com.squareup.picasso.Picasso

class AdapterArtikel(private var listArtikel: ArrayList<DataListArtikel>) :
    RecyclerView.Adapter<AdapterArtikel.myViewHolder>() {
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener

    }

    fun setData(result: List<DataListArtikel>){
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
        val thumbnailImageUrl = "echo.alghiffaryenterprise.id/uploads/{${item.thumbnail}}"
        holder.judul.text = item.title
        holder.image.setImageResource(R.drawable.ic_poll)
        holder.tim.text = item.user!!.name
    }

    override fun getItemCount() = listArtikel.size
}