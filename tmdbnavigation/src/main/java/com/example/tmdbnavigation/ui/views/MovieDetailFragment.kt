package com.example.tmdbnavigation.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.tmdbnavigation.databinding.FragmentMovieDetailBinding
import com.example.tmdbnavigation.ui.loadUrl
import com.example.tmdbnavigation.ui.viewmodels.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private val args: MovieDetailFragmentArgs by navArgs()
    private val viewModel: MovieDetailsViewModel by viewModels()
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        viewModel.getMovieDetails(args.movieId)
    }

    private fun observeLiveData() {
        viewModel.movieDetail.observe(viewLifecycleOwner) {
            with(it) {
                binding.title.text = title
                binding.description.text = overview
                binding.releaseDate.text = release_date
                poster_path?.let { url -> binding.image.loadUrl(url) }
            }
        }
    }
}