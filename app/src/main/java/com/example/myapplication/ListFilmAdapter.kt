package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFilmAdapter (private val listFilm: ArrayList<Film>) :RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView  = itemView.findViewById(R.id.img_item_photo)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription : TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
       val view :View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_film,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val (name , description , photo) = listFilm[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listFilm[holder.adapterPosition])}

    }

    override fun getItemCount(): Int = listFilm.size

    //calback adapter untuk onclick
    interface OnItemClickCallback {
        fun onItemClicked(data: Film)
    }



    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}