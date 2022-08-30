package com.example.tmdbnavigation.data.models

data class MoviesApiResponse(
    var dates: Dates,
    var page: Int,
    var results: List<MovieDto>,
    var total_pages: Int,
    var total_results: Int
)



