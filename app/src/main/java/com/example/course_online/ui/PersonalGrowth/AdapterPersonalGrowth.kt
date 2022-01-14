package com.example.course_online.ui.PersonalGrowth

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.topik.ModulesItem
import com.example.course_online.data.topik.ResponseListTopik
import com.example.course_online.ui.PelajariTopik.PelajariTopikActivity

class AdapterPersonalGrowth(private var listPersonal: ArrayList<ModulesItem>) :
    RecyclerView.Adapter<AdapterPersonalGrowth.myViewHolder>() {

    fun setData(result: List<ModulesItem>) {
        listPersonal.clear()
        listPersonal.addAll(result)
        notifyDataSetChanged()
    }

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout: RelativeLayout = itemView.findViewById(R.id.rv_item_pg)
        val image: ImageView = itemView.findViewById(R.id.img_materi)
        val imageSave: CheckBox = itemView.findViewById(R.id.img_save)
        val judul: TextView = itemView.findViewById(R.id.tv_judul_module)
        val tim: TextView = itemView.findViewById(R.id.tv_tim_module)
        var status: TextView = itemView.findViewById(R.id.tv_status_module)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topik, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val item = listPersonal[position]
        holder.imageSave.isChecked = false
        holder.image.setImageResource(R.drawable.ic_pg_one)
        holder.judul.text = item.title
        holder.tim.text = "Tim Personalities"
        holder.status.text = "Mulai"

        holder.layout.setOnClickListener {
            val intent = Intent(holder.itemView.context, PelajariTopikActivity::class.java)
                .putExtra("idCourse", item.courseId)
                .putExtra("idModul", item.iD)
            holder.itemView.context.startActivity(intent)
        }

        holder.status.setOnClickListener {
            val intent = Intent(holder.itemView.context, PelajariTopikActivity::class.java)
                .putExtra("idCourse", item.courseId)
                .putExtra("idModul", item.iD)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listPersonal.size

}