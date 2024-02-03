package dal.dal.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dal.dal.Models.Photo

@Database(
    entities = [Photo::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun getPhotoDAO(): PhotoDAO
}