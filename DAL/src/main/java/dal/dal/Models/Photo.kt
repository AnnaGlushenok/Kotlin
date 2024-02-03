package dal.dal.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
//    @SerializedName("photographerUrl")
    val photographer_url: String,
//    @SerializedName("photographerId")
    val photographer_id: Int,
//    @SerializedName("avgColor")
    val avg_color: String,
    val src: PhotoSource,
    val liked: Boolean,
    val alt: String
) : Serializable