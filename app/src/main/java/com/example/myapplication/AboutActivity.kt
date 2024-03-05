package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    //layout binding
    private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)



        Glide.with(this)
            .load(R.drawable.my)
            .circleCrop()
            .into(binding.ivProvile)
    }
}