package android.example.moviestest.di.module

import android.example.moviestest.di.annotation.ApplicationScope
import android.example.moviestest.domain.useCase.MoviesUseCase
import android.example.moviestest.presentation.viewModel.MoviesViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @ApplicationScope
    @Provides
    fun provideMoviesViewModel(
        moviesUseCase: MoviesUseCase
    ) = MoviesViewModel(moviesUseCase)
}