package android.example.moviestest.domain

import android.example.moviestest.domain.item.MovieItem
import androidx.lifecycle.LiveData

interface MoviesRepository {

    fun getMoviesApi(page: Int): List<MovieItem>

    suspend fun addMoviesDB(movies: List<MovieItem>)

    fun getMoviesDB(): LiveData<List<MovieItem>>

    suspend fun clearMoviesDB()
}