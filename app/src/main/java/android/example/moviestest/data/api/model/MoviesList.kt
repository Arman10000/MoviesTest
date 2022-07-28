package android.example.moviestest.data.api.model

import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("results")
    val movies: List<MovieModelApi>
)