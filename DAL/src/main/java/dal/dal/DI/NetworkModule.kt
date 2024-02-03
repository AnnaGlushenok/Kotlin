package dal.dal.DI

import dagger.Module
import dagger.Provides
import dal.dal.API.Const
import dal.dal.API.FeaturedCollectionsAPI
import dal.dal.API.PhotoAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    @Provides
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Const.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideServicePhotoAPI(retrofit: Retrofit): PhotoAPI =
        retrofit.create(PhotoAPI::class.java)

    @Provides
    fun provideServiceFeaturedCollectionsAPI(retrofit: Retrofit): FeaturedCollectionsAPI =
        retrofit.create(FeaturedCollectionsAPI::class.java)
}
