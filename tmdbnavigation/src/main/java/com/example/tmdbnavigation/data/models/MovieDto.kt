package com.example.tmdbnavigation.data.models

import com.example.tmdbnavigation.domain.models.Movie

data class MovieDto(
    var adult: Boolean,
    var backdrop_path: String?,
    var genre_ids: List<Int>,
    var id: Int,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var popularity: Float,
    var poster_path: String?,
    var release_date: String,
    var title: String,
    var video: Boolean,
    var vote_average: Float,
    var vote_count: Int,
)

fun MovieDto.toMovie(): Movie {
    return with(this) {
        Movie(
            id = id,
            original_language = original_language,
            original_title = original_title,
            overview = overview,
            popularity = popularity,
            poster_path = poster_path,
            release_date = release_date,
            title = title
        )
    }
}