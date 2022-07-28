package android.example.moviestest.data

import android.example.moviestest.data.api.MoviesApi
import android.example.moviestest.data.db.MoviesDao
import android.example.moviestest.data.mapper.MoviesMapper
import android.example.moviestest.domain.MoviesRepository
import android.example.moviestest.domain.item.MovieItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

class MoviesRepositoryImpl(
    private val moviesApi: MoviesApi,
    private val moviesDao: MoviesDao
) : MoviesRepository {

    override fun getMoviesApi(
        page: Int
    ): List<MovieItem> = MoviesMapper.mapListMovieModelApiToListMovieItem(
        moviesApi.getMovies(page).execute()
    )

    override suspend fun addMoviesDB(movies: List<MovieItem>) {
        moviesDao.addMovies(
            MoviesMapper.mapListMovieItemToListEntity(movies)
        )
    }

    override fun getMoviesDB(): LiveData<List<MovieItem>> {
        return Transformations.map(
            moviesDao.getMovies()
        ) {
            MoviesMapper.mapListEntityToListMovieItem(it)
        }
    }

    override suspend fun clearMoviesDB() {
        moviesDao.clearMovies()
    }
}