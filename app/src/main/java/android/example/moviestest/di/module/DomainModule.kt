package android.example.moviestest.di.module

import android.example.moviestest.domain.MoviesRepository
import android.example.moviestest.domain.useCase.MoviesUseCase
import android.example.moviestest.domain.useCase.MoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideMoviesUseCase(
        moviesRepository: MoviesRepository
    ): MoviesUseCase = MoviesUseCaseImpl(moviesRepository)
}