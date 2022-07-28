package android.example.moviestest.presentation.adapter

import android.example.moviestest.databinding.ItemMovieBinding
import android.example.moviestest.domain.item.MovieItem
import android.example.moviestest.presentation.adapter.callback.MovieItemDiffCallback
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MoviesAdapter :
    ListAdapter<MovieItem, MoviesAdapter.MovieViewHolder>(MovieItemDiffCallback()) {

    class MovieViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: MovieItem) {
            Picasso.get()
                .load(movieItem.imagePath)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(binding.image)
            binding.title.text = movieItem.title
            binding.description.text = movieItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieItem = getItem(position))
    }
}