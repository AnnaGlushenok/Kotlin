package dal.dal.API

import dal.dal.Models.Photos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PhotoAPI {
    @GET("v1/curated")
    suspend fun getPhotos(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
        @Header("Authorization") apiKey: String = Const.API_KEY
    ): Response<Photos>

    @GET("v1/search")
    suspend fun getPhotosByName(
        @Query("query") query: String,
        @Query("per_page") perPage: Int,
        @Header("Authorization") apiKey: String = Const.API_KEY
    ): Response<Photos>
}
