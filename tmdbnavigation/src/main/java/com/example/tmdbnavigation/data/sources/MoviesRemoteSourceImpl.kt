package com.example.tmdbnavigation.data.sources

import com.example.tmdbnavigation.data.models.MoviesApiResponse
import com.example.tmdbnavigation.data.service.MovieAPI
import retrofit2.Response
import javax.inject.Inject

class MoviesRemoteSourceImpl @Inject constructor(
    private val movieApi: MovieAPI
) : MoviesRemoteSource {

    override suspend fun getMovies(): Response<MoviesApiResponse> {
        return movieApi.getMovies()
    }
}