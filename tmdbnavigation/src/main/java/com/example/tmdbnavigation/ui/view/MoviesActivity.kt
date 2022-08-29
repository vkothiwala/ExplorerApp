package com.example.tmdbnavigation.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdbnavigation.R

class MoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
    }
}