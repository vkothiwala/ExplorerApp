package com.example.tmdbnavigation.data.sources

import com.example.tmdbnavigation.domain.models.Movie
import javax.inject.Inject

class MovieLocalSourceImpl @Inject constructor(): MovieLocalSource {

    private val cachedMovies = ArrayList<Movie>()

    override suspend fun cacheMovies(movies: List<Movie>) {
        cachedMovies.clear()
        cachedMovies.addAll(movies)
    }

    override suspend fun getMovies() = cachedMovies
}