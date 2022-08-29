package com.example.tmdbnavigation.ui.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbnavigation.R
import com.example.tmdbnavigation.domain.models.Movie

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var movieList: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount() = movieList.size

    fun submitList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val movieName = itemView.findViewById<TextView>(R.id.movie_name)
        private val movieDescription = itemView.findViewById<TextView>(R.id.movie_description)

        fun bind(movie: Movie) {
            with(movie) {
                movieName.text = name
                movieDescription.text = description
            }
        }
    }
}