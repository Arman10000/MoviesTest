package android.example.moviestest.data.api.model

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("src")
    val imagePath: String
)