package com.example.tmdbnavigation.domain.models

data class Movie(
    var id: Int,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var popularity: Float,
    var poster_path: String?,
    var release_date: String,
    var title: String
)
