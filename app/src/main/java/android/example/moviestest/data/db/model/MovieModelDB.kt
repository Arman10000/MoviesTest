package android.example.moviestest.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieModelDB(
    val title: String,
    val description: String,
    val imagePath: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
