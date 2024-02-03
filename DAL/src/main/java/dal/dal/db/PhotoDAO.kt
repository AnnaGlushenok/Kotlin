package dal.dal.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dal.dal.Models.Photo

@Dao
interface PhotoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(photo: Photo): Long

    @Query("SELECT * FROM photos")
    suspend fun getAllPhotos(): List<Photo>

    @Delete
    suspend fun deletePhoto(photo: Photo)
}