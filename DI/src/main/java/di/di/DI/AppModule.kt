package dal.dal.DI

import dagger.Module
import dagger.Provides
import dal.dal.API.PhotoAPI
import di.di.API.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object AppModule {
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Const.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideServiceAPI(retrofit: Retrofit): PhotoAPI {
        return retrofit.create(PhotoAPI::class.java)
    }
}