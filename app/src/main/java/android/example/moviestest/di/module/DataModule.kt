package android.example.moviestest.di.module

import android.app.Application
import android.example.moviestest.data.MoviesRepositoryImpl
import android.example.moviestest.data.api.MoviesApi
import android.example.moviestest.data.db.MoviesDao
import android.example.moviestest.data.db.MoviesDatabase
import android.example.moviestest.domain.MoviesRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/reviews/"

@Module
class DataModule {

    @Provides
    fun provideMoviesApi(): MoviesApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesApi::class.java)

    @Provides
    fun provideMoviesDao(
        application: Application
    ) = MoviesDatabase.getInstance(application).getMoviesDao()

    @Provides
    fun provideMoviesRepository(
        moviesApi: MoviesApi,
        moviesDao: MoviesDao
    ): MoviesRepository = MoviesRepositoryImpl(
        moviesApi,
        moviesDao
    )
}