package dal.dal.db

import androidx.room.TypeConverter
import dal.dal.Models.PhotoSource

class Converter {
    @TypeConverter
    fun fromPhotoSource(photoSource: PhotoSource): String =
        photoSource.large

    @TypeConverter
    fun toPhotoSource(str: String): PhotoSource =
        PhotoSource(str, str, str, str, str, str, str, str)
}