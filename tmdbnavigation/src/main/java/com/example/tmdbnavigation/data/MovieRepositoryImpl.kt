package com.example.tmdbnavigation.data

import com.example.tmdbnavigation.domain.Movie
import com.example.tmdbnavigation.domain.MovieRepository
import kotlinx.coroutines.delay

class MovieRepositoryImpl : MovieRepository {

    private val movieList = listOf(
        Movie("Movie1", "Movie1 Description"),
        Movie("Movie1", "Movie1 Description"),
        Movie("Movie1", "Movie1 Description"),
        Movie("Movie1", "Movie1 Description"),
        Movie("Movie1", "Movie1 Description"),
        Movie("Movie1", "Movie1 Description"),
        Movie("Movie1", "Movie1 Description")
    )

    override suspend fun getMovies(): List<Movie> {
        delay(2000)
        return movieList
    }
}