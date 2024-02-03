package dal.dal.DI

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dal.dal.db.PhotoDatabase

@Module
class DatabaseModule {
    @Provides
    fun providePhotoDB(context: Context): PhotoDatabase =
        Room.databaseBuilder(context, PhotoDatabase::class.java, "photoDB")
            .build()
}
