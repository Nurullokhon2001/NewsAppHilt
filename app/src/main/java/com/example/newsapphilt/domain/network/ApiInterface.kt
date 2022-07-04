package com.example.newsapphilt.domain.network

import com.example.newsapphilt.domain.model.NewsModel
import dagger.Module
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

const val API_KEY = "5a3e054de1834138a2fbc4a75ee69053"

interface ApiInterface {
    @GET("everything")
    suspend fun getPopularNews(
        @Query("q") q: String = "apple",
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("pageSize") pageSize: Int = 5
    ): Response<NewsModel>
}