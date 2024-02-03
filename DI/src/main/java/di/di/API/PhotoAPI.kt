package dal.dal.API

import android.provider.Contacts
import di.di.API.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PhotoAPI {
    @GET("v1/curated")
    suspend fun getPhotos(
        @Query("per_page") perPage: Int,
        @Header("Authorization") apiKey: String = Const.API_KEY
    ): Response<Contacts.Photos>
}
