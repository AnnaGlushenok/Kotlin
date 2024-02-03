package dal.dal.API

import dal.dal.Models.FeaturedCollections
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FeaturedCollectionsAPI {
    @GET("v1/collections/featured")
    suspend fun getFeaturedCollections(
        @Query("per_page") perPage: Int,
        @Header("Authorization") apiKey: String = Const.API_KEY
    ): Response<FeaturedCollections>
}