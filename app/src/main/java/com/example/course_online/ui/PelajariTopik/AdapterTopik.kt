package com.example.course_online.ui.PelajariTopik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.topik.ModulesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_artikel.*

class AdapterTopik(private var listTopik : ArrayList<ModulesItem>)
    : RecyclerView.Adapter<AdapterTopik.myViewHolder>(){

    fun setData(result: List<ModulesItem>){
        listTopik.clear()
        listTopik.addAll(result)
        notifyDataSetChanged()
    }

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.iv_ilustrasiTopik)
        val judul : TextView = itemView.findViewById(R.id.tv_judulTopik)
        val isi : TextView = itemView.findViewById(R.id.tv_isiTopik)

        fun bind(get: ModulesItem){
            val thumbnailUri = "https://echo.alghiffaryenterprise.id/uploads/${get.thumbnail}"
            Picasso.get()
                .load(thumbnailUri)
                .fit()
                .placeholder(R.drawable.ic_detail_artikel)
                .into(image)
            judul.text = get.title
            isi.text = get.content
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