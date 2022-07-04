package com.example.newsapphilt.domain.network

import com.example.newsapphilt.domain.model.NewsModel
import retrofit2.Response


interface NewsInterface {
  suspend fun  getPopularNews() : Response<NewsModel>
}