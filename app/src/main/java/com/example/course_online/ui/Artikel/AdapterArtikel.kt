package com.example.course_online.ui.Artikel

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.course_online.R
import com.example.course_online.data.PrefsManagers
import com.example.course_online.data.ResponseSaveArticle
import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.network.ApiClient
import com.example.course_online.ui.DetailArtikelActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import android.util.Base64
import com.example.course_online.data.ResponseUnsaveArticle

class AdapterArtikel(
    private var listArtikel: ArrayList<DataListArtikel>, var prefsManagers: PrefsManagers,
) :
    RecyclerView.Adapter<AdapterArtikel.myViewHolder>() {

    fun setData(result: List<DataListArtikel>) {
        listArtikel.clear()
        listArtikel.addAll(result)
        notifyDataSetChanged()
    }

    inner class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rv_artikel: RelativeLayout = itemView.findViewById(R.id.rv_item_artikel)
        val read_artikel: TextView = itemView.findViewById(R.id.tv_read_artikel)
        val image: ImageView = itemView.findViewById(R.id.img_artikel)
        val imageSave: CheckBox = itemView.findViewById(R.id.cb_save_article)
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

            prefsManagers = PrefsManagers(itemView.context)
            imageSave.setOnCheckedChangeListener { c, isChecked ->
                if (isChecked) {
                    ApiClient.endPoint.saveArticle(
                        token = "Bearer ${prefsManagers.prefsToken}",
                        "3",
                        idArtikel
                    ).enqueue(object : Callback<ResponseSaveArticle> {
                        override fun onResponse(
                            call: Call<ResponseSaveArticle>,
                            response: Response<ResponseSaveArticle>
                        ) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    itemView.context,
                                    "Artikel di Simpan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    itemView.context,
                                    "Artikel Gagal di Simpan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onFailure(call: Call<ResponseSaveArticle>, t: Throwable) {
                            Toast.makeText(itemView.context, "$t", Toast.LENGTH_SHORT).show()
                        }

                    })

                } else {
                    ApiClient.endPoint.unSaveArticle(
                        token = "Bearer ${prefsManagers.prefsToken}",
                        "3",
                        idArtikel!!
                    )
                        .enqueue(object : Callback<ResponseUnsaveArticle> {
                            override fun onResponse(
                                call: Call<ResponseUnsaveArticle>,
                                response: Response<ResponseUnsaveArticle>
                            ) {
                                if (response.isSuccessful) {
                                    Toast.makeText(
                                        itemView.context,
                                        "Simpan Artikel di hapus",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        itemView.context,
                                        "Di hapus Gagal",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                            override fun onFailure(
                                call: Call<ResponseUnsaveArticle>,
                                t: Throwable
                            ) {
                                Toast.makeText(itemView.context, "$t", Toast.LENGTH_SHORT).show()
                            }

                        })
                }
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