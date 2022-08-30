package com.example.tmdbnavigation.ui

import android.widget.ImageView
import com.bumptech.glide.Glide

const val PATH = "https://image.tmdb.org/t/p/original/"

fun ImageView.loadUrl(url: String) = Glide.with(this).load("$PATH$url").into(this)