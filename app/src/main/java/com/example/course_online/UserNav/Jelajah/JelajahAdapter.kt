package com.example.course_online.UserNav.Jelajah

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import kotlinx.android.synthetic.main.item_jelajah.view.*

class JelajahAdapter(
    private var listJelajah: ArrayList<Jelajah>
) :
    RecyclerView.Adapter<JelajahAdapter.VIewHolder>() {
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener

    }
    class VIewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val image: ImageView = itemView.findViewById(R.id.img_jelajah)
        val title: TextView = itemView.findViewById(R.id.tv_judul_artikel)
        val desc: TextView = itemView.findViewById(R.id.tv_desc_jelajah)
        val btn: TextView = itemView.findViewById(R.id.btn_pelajariJelajah)
        init {
            itemView.btn_pelajariJelajah.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VIewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_jelajah, parent, false)
        return VIewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: VIewHolder, position: Int) {
        val item = listJelajah[position]
        holder.image.setImageResource(item.ImageIcon)
        holder.title.text = item.Judul
        holder.desc.text = item.Desc
        holder.btn.text = item.Button
    }

    override fun getItemCount() = listJelajah.size
}