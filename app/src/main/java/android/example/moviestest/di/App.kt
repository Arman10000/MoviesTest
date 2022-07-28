package android.example.moviestest.di

import android.app.Application
import android.example.moviestest.di.component.DaggerMoviesComponent

class App : Application() {
    val moviesComponent by lazy {
        DaggerMoviesComponent.factory().create(this)
    }
}