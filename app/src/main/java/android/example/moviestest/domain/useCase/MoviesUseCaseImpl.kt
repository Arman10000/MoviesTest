package android.example.moviestest.domain.useCase

import android.example.moviestest.domain.MoviesRepository
import android.example.moviestest.domain.item.MovieItem
import androidx.lifecycle.LiveData

class MoviesUseCaseImpl(
    private val moviesRepository: MoviesRepository
) : MoviesUseCase {

    override suspend fun startLoadingMovies(page: Int) {
        val movies = moviesRepository.getMoviesApi(page)

        if (movies.isNotEmpty()) {
            if (page == 1) moviesRepository.clearMoviesDB()
            moviesRepository.addMoviesDB(movies)
        }
    }

    override fun getMoviesDB(): LiveData<List<MovieItem>> =
        moviesRepository.getMoviesDB()
}