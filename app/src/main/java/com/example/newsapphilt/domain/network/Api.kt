package com.example.newsapphilt.domain.network

import com.example.newsapphilt.domain.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "5a3e054de1834138a2fbc4a75ee69053"

interface Api {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsModel>
}