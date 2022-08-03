package com.fede.firebase.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fede.firebase.Pelicula
import com.fede.firebase.R

class PeliculaViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val pelicula = view.findViewById<TextView>(R.id.tvPeliculaTitulo)
    val peliculaPoster = view.findViewById<ImageView>(R.id.ivPeliculaPoster)
    fun render(peliculaModel: Pelicula){
        pelicula.text=peliculaModel.title
        Glide.with(peliculaPoster.context).load(peliculaModel.poster).into(peliculaPoster)
    }

}