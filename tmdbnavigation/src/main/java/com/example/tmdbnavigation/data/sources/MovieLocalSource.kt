package com.example.tmdbnavigation.data.sources

import com.example.tmdbnavigation.domain.models.Movie

interface MovieLocalSource {

    suspend fun cacheMovies(movies: List<Movie>)
    suspend fun getMovies(): List<Movie>
}