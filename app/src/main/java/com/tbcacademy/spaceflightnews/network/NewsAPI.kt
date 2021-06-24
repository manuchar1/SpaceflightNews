package com.tbcacademy.spaceflightnews.network




import com.tbcacademy.spaceflightnews.models.ArticlesItem
import com.tbcacademy.spaceflightnews.utils.Constants.API_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET(API_ENDPOINT)
    suspend fun getArticles(): Response<List<ArticlesItem>>

    @GET(API_ENDPOINT)
    suspend fun searchForArticles(
        @Query("=")
        searchQuery: String,
    ): Response<List<ArticlesItem>>

}