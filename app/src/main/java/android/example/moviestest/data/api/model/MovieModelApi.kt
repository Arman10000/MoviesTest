package android.example.moviestest.data.api.model

import com.google.gson.annotations.SerializedName

data class MovieModelApi(
    @SerializedName("display_title")
    val title: String,
    @SerializedName("summary_short")
    val description: String,
    @SerializedName("multimedia")
    val imageObject: ImageModel
)