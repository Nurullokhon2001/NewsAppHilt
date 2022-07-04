package com.example.newsapphilt.domain.network


interface NewsInterface {
  suspend fun  getPopularNews(q : String)
}