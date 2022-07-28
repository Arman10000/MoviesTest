package android.example.moviestest.data.db

import android.example.moviestest.data.db.model.MovieModelDB
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoviesDao {

    @Insert
    suspend fun addMovies(movies: List<MovieModelDB>)

    @Query("SELECT * FROM movies")
    fun getMovies(): LiveData<List<MovieModelDB>>

    @Query("DELETE FROM movies")
    suspend fun clearMovies()
}