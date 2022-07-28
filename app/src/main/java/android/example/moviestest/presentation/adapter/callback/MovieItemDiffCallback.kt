package android.example.moviestest.presentation.adapter.callback

import android.example.moviestest.domain.item.MovieItem
import androidx.recyclerview.widget.DiffUtil

class MovieItemDiffCallback : DiffUtil.ItemCallback<MovieItem>() {

    override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return true
    }
}