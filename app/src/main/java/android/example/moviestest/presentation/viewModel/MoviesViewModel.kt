package android.example.moviestest.presentation.viewModel

import android.example.moviestest.domain.item.MovieItem
import android.example.moviestest.domain.useCase.MoviesUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private var _error: MutableLiveData<Boolean> = MutableLiveData()
    val error: LiveData<Boolean> = _error
    private var _progressBar: MutableLiveData<Boolean> = MutableLiveData()
    val progressBar: LiveData<Boolean> = _progressBar
    val movies: LiveData<List<MovieItem>> = moviesUseCase.getMoviesDB()
    private var isLoading = false
    private var isErrorInternet = false
    private var page = 1
    private var firstStartMovies = true

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _error.postValue(true)
        isErrorInternet = true
        _progressBar.postValue(false)
    }

    private fun startLoadingMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _progressBar.postValue(true)
            isLoading = true
            moviesUseCase.startLoadingMovies(page)
            isErrorInternet = false
            isLoading = false
            _progressBar.postValue(false)
        }
    }

    fun ifFirstStartMovies() {
        if (firstStartMovies) {
            firstStartMovies = false
            startLoadingMovies()
        }
    }

    fun loadingMoviesIfEndList(
        totalItemCount: Int,
        visibleItemCount: Int,
        showItemCount: Int
    ) {
        if (
            showItemCount > 0 &&
            (visibleItemCount + showItemCount) >= totalItemCount &&
            !isLoading
        ) {
            if (!isErrorInternet) page++
            startLoadingMovies()
        }
    }

    fun refreshLayout() {
        page = 1
        startLoadingMovies()
    }
}