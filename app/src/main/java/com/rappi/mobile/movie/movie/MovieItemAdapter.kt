package com.rappi.mobile.movie.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rappi.mobile.movie.R
import com.rappi.mobile.movie.databinding.ItemMovieBinding
import com.rappi.mobile.movie.models.result.MovieItemResult

class MovieItemAdapter(
    private val movieList: List<MovieItemResult>,
    private val action: (movie: MovieItemResult) -> Unit
) :
    RecyclerView.Adapter<MovieItemAdapter.MovieItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    inner class MovieItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movieItemResult: MovieItemResult) {
            val binding = DataBindingUtil.bind<ItemMovieBinding>(itemView)
            binding?.let {
                it.movieTitle.text = movieItemResult.name
                it.movieDescription.text = movieItemResult.description
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/${movieItemResult.backgroundImage}")
                    .into(it.posterImage)
            }
            itemView.setOnClickListener { action(movieItemResult) }
        }
    }
}