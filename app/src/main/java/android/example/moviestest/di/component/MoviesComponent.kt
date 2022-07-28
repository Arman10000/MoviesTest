package android.example.moviestest.di.component

import android.app.Application
import android.example.moviestest.di.annotation.ApplicationScope
import android.example.moviestest.di.module.DataModule
import android.example.moviestest.di.module.DomainModule
import android.example.moviestest.di.module.ViewModelModule
import android.example.moviestest.presentation.screen.Movies
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class
    ]
)
interface MoviesComponent {

    fun inject(movies: Movies)

    @Component.Factory
    interface ComponentFactory {
        fun create(
            @BindsInstance application: Application
        ): MoviesComponent
    }
}