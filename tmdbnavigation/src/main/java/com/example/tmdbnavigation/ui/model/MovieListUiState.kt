package com.example.tmdbnavigation.ui.model

import com.example.tmdbnavigation.domain.Movie

data class MovieListUiState(
    val isLoading: Boolean,
    val movieList: List<Movie>,
    val error: Boolean
)
