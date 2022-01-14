package com.example.course_online.UserNav.Home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.data.topik.ResponseListTopik
import com.example.course_online.ui.PersonalGrowth.PersonalGrowtActivity
import com.squareup.picasso.Picasso

class AdapterModulPilihan(private var  listModul: ArrayList<ResponseListTopik>)
    : RecyclerView.Adapter<AdapterModulPilihan.myViewHolder>(){

    fun setData(result: List<ResponseListTopik>) {
        listModul.clear()
        listModul.addAll(result)
        notifyDataSetChanged()
    }

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var id : Int = 0
        val image : ImageView = itemView.findViewById(R.id.iv_imgModul)
        val judul : TextView = itemView.findViewById(R.id.tv_judulModul)
        val desc : TextView = itemView.findViewById(R.id.tv_descModul)
        val currProgress : TextView = itemView.findViewById(R.id.curr_progress)
        val maxTopic : TextView = itemView.findViewById(R.id.max_topic)
        val pelajariBtn : Button = itemView.findViewById(R.id.btn_pelajariModul)

        fun bind(get: ResponseListTopik) {
            id = get.iD!!
            val thumbnailUri = "https://echo.alghiffaryenterprise.id/uploads/${get.thumbnail}"

            Picasso.get()
                .load(thumbnailUri)
                .fit()
                .into(image)
            Log.i("Thumbnail", thumbnailUri)

            judul.text = get.title
            desc.text = get.description
            currProgress.text = "0"
            maxTopic.text = get.modules?.size.toString()
            pelajariBtn.setOnClickListener {
                val intent = Intent(itemView.context, PersonalGrowtActivity::class.java)
                    .putExtra("idCourse", id)
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