package com.example.newsapphilt.domain.local

import com.example.newsapphilt.data.local.ArticleEntity

interface LocalNewsInterface {

    fun getFavoriteNews(): List<ArticleEntity>

    suspend fun insertFavoriteNews(news: ArticleEntity)

    suspend fun deleteFavoriteNews(id: Int)

}