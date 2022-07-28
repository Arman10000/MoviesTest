package android.example.moviestest.data.db

import android.app.Application
import android.example.moviestest.data.db.model.MovieModelDB
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MovieModelDB::class],
    version = 1,
    exportSchema = false
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao

    companion object {
        private const val DB_NAME = "main.db"

        fun getInstance(
            application: Application
        ): MoviesDatabase = Room.databaseBuilder(application, MoviesDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}