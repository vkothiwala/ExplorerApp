package com.example.tmdbnavigation.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.tmdbnavigation.databinding.FragmentMovieListBinding
import com.example.tmdbnavigation.ui.viewmodels.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val viewModel: MovieListViewModel by viewModels()
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observerLiveData()
        viewModel.start()
    }

    private fun initViews() {
        with(binding.movieList) {
            movieListAdapter = MovieListAdapter()
            adapter = movieListAdapter
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun observerLiveData() {
        viewModel.movieListUiState.observe(viewLifecycleOwner) {
            binding.loader.isVisible = it.isLoading
            if (it.movieList.isNotEmpty()) {
                movieListAdapter.submitList(it.movieList)
            }
            // TODO: Implement error case in future
        }
    }
}