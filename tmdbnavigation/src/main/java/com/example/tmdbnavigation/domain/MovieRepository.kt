package com.example.tmdbnavigation.domain

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}