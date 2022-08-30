package com.example.tmdbnavigation.data.sources

import android.util.Log
import com.example.tmdbnavigation.data.models.toMovie
import com.example.tmdbnavigation.domain.MovieRepository
import com.example.tmdbnavigation.domain.models.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteSource: MovieRemoteSource,
    private val localSource: MovieLocalSource
) : MovieRepository {

    private val TAG = "MovieRepositoryImpl"

    override suspend fun getMovies(): List<Movie> {
        try {
            val response = remoteSource.getMovies()
            if (response.isSuccessful && response.code() == 200 && response.body() != null) {
                val result = response.body()!!.results.map { it.toMovie() }
                Log.d(TAG, "$localSource, $result")
                localSource.cacheMovies(result)
            }
        } catch (e: Exception) {
            Log.d(TAG, e.toString())
        }
        return localSource.getMovies()
    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return localSource.getMovies().find { it.id == movieId }!!
    }
}