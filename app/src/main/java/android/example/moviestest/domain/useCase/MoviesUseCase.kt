package android.example.moviestest.domain.useCase

import android.example.moviestest.domain.item.MovieItem
import androidx.lifecycle.LiveData

interface MoviesUseCase {

    suspend fun startLoadingMovies(page: Int)

    fun getMoviesDB(): LiveData<List<MovieItem>>
}