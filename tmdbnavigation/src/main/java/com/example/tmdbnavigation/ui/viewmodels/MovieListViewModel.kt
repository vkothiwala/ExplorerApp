package com.example.tmdbnavigation.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbnavigation.domain.MovieRepository
import com.example.tmdbnavigation.ui.models.MovieListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movieListUiState: MutableLiveData<MovieListUiState> = MutableLiveData()
    val movieListUiState: LiveData<MovieListUiState> = _movieListUiState

    internal fun start() {
        _movieListUiState.value = MovieListUiState(true, emptyList(), false)

        viewModelScope.launch {
            val movies = repository.getMovies()
            _movieListUiState.value = MovieListUiState(false, movies, false)
        }
    }
}