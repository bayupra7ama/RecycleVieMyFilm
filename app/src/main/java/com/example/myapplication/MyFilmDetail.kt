package com.example.myapplication

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMyFilmDetailBinding

class MyFilmDetail : AppCompatActivity() {

    //viewBinding
    private lateinit var binding: ActivityMyFilmDetailBinding

    companion object{
        const  val DATA_FILM = "data_film"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyFilmDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = if(Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(DATA_FILM,Film::class.java)
        }else {
            @Suppress "DEPRECATION"
            intent.getParcelableExtra<Film>(DATA_FILM)
        }
        if (film != null){
            val name  = film.judul
            val deskripsi = film.deskripsi
            val photo = film.photo

            Glide.with(this).
            load(photo).
            into(binding.imgPhoto)

            binding.imgNamaPhoto.text = name
            binding.tvJudulFilm.text = name
            binding.tvDescription.text = deskripsi


        }
    }
}