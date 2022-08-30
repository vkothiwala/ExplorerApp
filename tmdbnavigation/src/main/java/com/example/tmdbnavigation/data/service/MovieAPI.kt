package com.example.tmdbnavigation.data.service

import com.example.tmdbnavigation.data.models.MoviesApiResponse
import retrofit2.Response
import retrofit2.http.GET

const val API_KEY = "ad35eeedf999e78fd5e38d13c53f5ad8"

interface MovieAPI {

    @GET("now_playing?api_key=$API_KEY&language=en-US&page=1")
    suspend fun getMovies(): Response<MoviesApiResponse>
}