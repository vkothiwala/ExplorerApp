package com.example.tmdbnavigation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbnavigation.data.MovieRepositoryImpl
import com.example.tmdbnavigation.ui.model.MovieListUiState
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {

    private val _movieListUiState: MutableLiveData<MovieListUiState> = MutableLiveData()
    val movieListUiState: LiveData<MovieListUiState> = _movieListUiState

    internal fun start() {
        _movieListUiState.value = MovieListUiState(true, emptyList(), false)

        viewModelScope.launch {
            val movies = MovieRepositoryImpl().getMovies()
            _movieListUiState.value = MovieListUiState(false, movies, false)
        }
    }
}