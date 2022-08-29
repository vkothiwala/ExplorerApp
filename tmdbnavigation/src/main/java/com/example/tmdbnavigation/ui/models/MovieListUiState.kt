package com.example.tmdbnavigation.ui.models

import com.example.tmdbnavigation.domain.models.Movie

data class MovieListUiState(
    val isLoading: Boolean,
    val movieList: List<Movie>,
    val error: Boolean
)
