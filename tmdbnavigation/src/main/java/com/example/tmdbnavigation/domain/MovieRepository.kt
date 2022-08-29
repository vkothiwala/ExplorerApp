package com.example.tmdbnavigation.domain

import com.example.tmdbnavigation.domain.models.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}