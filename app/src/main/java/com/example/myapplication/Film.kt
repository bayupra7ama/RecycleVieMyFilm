package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val judul : String?,
    val deskripsi:String?,
    val photo : Int
):Parcelable
