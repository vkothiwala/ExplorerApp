package com.example.tmdbnavigation.data.sources

import com.example.tmdbnavigation.data.models.MoviesApiResponse
import com.example.tmdbnavigation.data.service.MovieAPI
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteSourceImpl @Inject constructor(
    private val movieApi: MovieAPI
) : MovieRemoteSource {

    override suspend fun getMovies(): Response<MoviesApiResponse> {
        return movieApi.getMovies()
    }
}