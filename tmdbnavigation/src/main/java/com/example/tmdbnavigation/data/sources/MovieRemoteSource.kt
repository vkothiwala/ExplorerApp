package com.example.tmdbnavigation.data.sources

import com.example.tmdbnavigation.data.models.MoviesApiResponse
import retrofit2.Response

interface MovieRemoteSource {

    suspend fun getMovies(): Response<MoviesApiResponse>
}