package com.example.course_online.UserNav.Home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.ui.PersonalGrowth.PersonalGrowtActivity

class AdapterModulPilihan(private var  listModul: ArrayList<ModulPilihan>)
    : RecyclerView.Adapter<AdapterModulPilihan.myViewHolder>(){

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.iv_imgModul)
        val judul : TextView = itemView.findViewById(R.id.tv_judulModul)
        val desc : TextView = itemView.findViewById(R.id.tv_descModul)
        val currProgress : TextView = itemView.findViewById(R.id.curr_progress)
        val maxTopic : TextView = itemView.findViewById(R.id.max_topic)
        val pelajariBtn : Button = itemView.findViewById(R.id.btn_pelajariModul)

        fun bind(get: ModulPilihan) {
            image.setImageResource(get.imageModul)
            judul.text = get.judulModul
            desc.text = get.descModul
            currProgress.text = get.currProgress.toString()
            maxTopic.text = get.maxTopic.toString()
            pelajariBtn.setOnClickListener {
                val intent = Intent(itemView.context, PersonalGrowtActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_modul, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(listModul[position])
    }

    override fun getItemCount() = listModul.size
}