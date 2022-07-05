package com.example.newsapphilt.data.local

import com.example.newsapphilt.domain.local.LocalNewsInterface

class LocalNewsInterfaceImpl(private val newsDao: NewsDao) : LocalNewsInterface {
    override fun getFavoriteNews(): List<ArticleEntity> {
        return newsDao.getAllData()
    }

    override suspend fun insertFavoriteNews(news: ArticleEntity) {
        newsDao.insert(news)
    }

    override suspend fun deleteFavoriteNews(id: Int) {
        newsDao.deleteFavoriteNews(id)
    }
}