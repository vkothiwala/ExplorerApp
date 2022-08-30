package com.example.tmdbnavigation.data.sources

import com.example.tmdbnavigation.data.models.MoviesApiResponse
import retrofit2.Response

interface MoviesRemoteSource {

    suspend fun getMovies(): Response<MoviesApiResponse>
}

/*
*
* https://api.themoviedb.org/3/movie/now_playing?api_key=ad35eeedf999e78fd5e38d13c53f5ad8&language=en-US&page=1
* https://api.themoviedb.org/3/movie/550?api_key=ad35eeedf999e78fd5e38d13c53f5ad8
* */