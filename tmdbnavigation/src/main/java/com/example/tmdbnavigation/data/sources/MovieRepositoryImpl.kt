package com.example.tmdbnavigation.data.sources

import android.util.Log
import com.example.tmdbnavigation.data.models.toMovie
import com.example.tmdbnavigation.domain.MovieRepository
import com.example.tmdbnavigation.domain.models.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteSource: MoviesRemoteSource
) : MovieRepository {

    private val TAG = "MovieRepositoryImpl"

    override suspend fun getMovies(): List<Movie> {
        return try {
            val response = remoteSource.getMovies()
            val result =
                if (response.isSuccessful && response.code() == 200 && response.body() != null) {
                    response.body()!!.results.map { it.toMovie() }
                } else {
                    emptyList()
                }
            Log.d(TAG, result.toString())
            result
        } catch (e: Exception) {
            Log.d(TAG, e.toString())
            emptyList()
        }
    }
}