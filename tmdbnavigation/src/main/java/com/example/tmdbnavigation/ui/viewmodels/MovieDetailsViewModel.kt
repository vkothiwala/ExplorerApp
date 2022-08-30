package com.example.tmdbnavigation.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbnavigation.domain.MovieRepository
import com.example.tmdbnavigation.domain.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movieDetail: MutableLiveData<Movie> = MutableLiveData()
    val movieDetail: LiveData<Movie> = _movieDetail

    internal fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _movieDetail.value = repository.getMovieDetails(movieId)
        }
    }
}