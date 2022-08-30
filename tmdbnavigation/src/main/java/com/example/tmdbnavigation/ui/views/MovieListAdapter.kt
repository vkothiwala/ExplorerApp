package com.example.tmdbnavigation.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbnavigation.R
import com.example.tmdbnavigation.domain.models.Movie

class MovieListAdapter(private val onMovieClick: (Int) -> Unit) :
    RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var movieList: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return MovieViewHolder(view) {
            onMovieClick(movieList[it].id)
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount() = movieList.size

    fun submitList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View, clickItemPosition: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val movieName = itemView.findViewById<TextView>(R.id.movie_name)
        private val movieReleaseDate = itemView.findViewById<TextView>(R.id.movie_release_date)
        private val movieImage = itemView.findViewById<ImageView>(R.id.movie_image)

        init {
            itemView.setOnClickListener { clickItemPosition(adapterPosition) }
        }

        fun bind(movie: Movie) {
            with(movie) {
                movieName.text = title
                movieReleaseDate.text = release_date
                Glide.with(movieImage).load("$PATH$poster_path").into(movieImage)
            }
        }

        companion object {
            const val PATH = "https://image.tmdb.org/t/p/original/"
        }
    }
}