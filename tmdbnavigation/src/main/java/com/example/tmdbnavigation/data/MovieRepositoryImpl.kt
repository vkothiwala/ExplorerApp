package com.example.tmdbnavigation.data

import com.example.tmdbnavigation.domain.MovieRepository
import com.example.tmdbnavigation.domain.models.Movie
import kotlinx.coroutines.delay
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor() : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        delay(2000)
        val movieList = ArrayList<Movie>()
        for (i in 1..20) {
            movieList.add(Movie("Movie$i", "Movie$i Description"))
        }
        return movieList
    }
}