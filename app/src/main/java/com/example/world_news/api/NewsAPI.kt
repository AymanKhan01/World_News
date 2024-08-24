package com.example.world_news.api

import com.example.world_news.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") countryCode: String = "in",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>

    abstract fun getHeadlines(countryCode: String, pageNumber: Int): Response<NewsResponse>
    abstract fun searchForNews(searchQuery: String, pageNumber: Int): Response<NewsResponse>
}
