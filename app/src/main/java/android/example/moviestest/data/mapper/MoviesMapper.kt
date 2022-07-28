package android.example.moviestest.data.mapper

import android.example.moviestest.data.api.model.MoviesList
import android.example.moviestest.data.db.model.MovieModelDB
import android.example.moviestest.domain.item.MovieItem
import retrofit2.Response

class MoviesMapper {

    companion object {

        fun mapListMovieModelApiToListMovieItem(
            response: Response<MoviesList>
        ): List<MovieItem> {
            response.body()?.let {
                return it.movies.map { movieModelApi ->
                    MovieItem(
                        movieModelApi.title,
                        movieModelApi.description,
                        movieModelApi.imageObject.imagePath
                    )
                }
            }

            return listOf()
        }

        fun mapListMovieItemToListEntity(
            movies: List<MovieItem>
        ): List<MovieModelDB> = movies.map {
            MovieModelDB(
                it.title,
                it.description,
                it.imagePath
            )
        }

        fun mapListEntityToListMovieItem(
            movies: List<MovieModelDB>
        ): List<MovieItem> = movies.map {
            MovieItem(
                it.title,
                it.description,
                it.imagePath
            )
        }
    }
}