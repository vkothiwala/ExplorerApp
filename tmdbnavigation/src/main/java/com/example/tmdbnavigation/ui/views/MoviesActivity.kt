package com.example.tmdbnavigation.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tmdbnavigation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
    }
}