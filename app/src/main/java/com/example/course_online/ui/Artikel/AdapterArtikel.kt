package com.example.course_online.ui.Artikel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R

class AdapterArtikel(private var listArtikel: ArrayList<Artikel>) :
    RecyclerView.Adapter<AdapterArtikel.myViewHolder>() {
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener

    }

    class myViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val image: ImageView = itemView.findViewById(R.id.img_materi)
        val imageSave: ImageView = itemView.findViewById(R.id.img_save)
        val judul: TextView = itemView.findViewById(R.id.tv_judul_module)
        val tim: TextView = itemView.findViewById(R.id.tv_tim_module)
        var status: TextView = itemView.findViewById(R.id.tv_status_module)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topik, parent, false)
        return myViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val item = listArtikel[position]
        holder.image.setImageResource(item._Icon)
        holder.imageSave.setImageResource(item._ImageSave)
        holder.judul.text = item._Title
        holder.tim.text = item._Tim
        holder.status.text = item._Status
    }

    override fun getItemCount() = listArtikel.size
}