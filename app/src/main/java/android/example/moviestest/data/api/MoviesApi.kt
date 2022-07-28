package android.example.moviestest.data.api

import android.example.moviestest.data.api.model.MoviesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    companion object {
        private const val API_KEY = "DpiBlpNXE4IYeHxtTWV7Z90S0BhZ6FKD"
        private const val PARAMS_API_KEY = "api-key"
        private const val PARAMS_PAGE = "offset"
        private const val URL_MOVIES = "picks.json"
    }

    @GET("$URL_MOVIES?$PARAMS_API_KEY=$API_KEY")
    fun getMovies(
        @Query(PARAMS_PAGE) page: Int
    ): Call<MoviesList>
}