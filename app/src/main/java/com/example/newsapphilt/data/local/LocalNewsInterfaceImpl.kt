package com.example.newsapphilt.data.local

import com.example.newsapphilt.domain.local.LocalNewsInterface

class LocalNewsInterfaceImpl(private val newsDao: NewsDao) : LocalNewsInterface {
  override suspend fun getFavoriteNews(): List<ArticleEntity> {
        return newsDao.getAllData()
    }

    override suspend fun insertFavoriteNews(news: ArticleEntity) {
        newsDao.insert(news)
    }

    override suspend fun deleteFavoriteNews(url: String) {
        newsDao.deleteFavoriteNews(url)
    }
}