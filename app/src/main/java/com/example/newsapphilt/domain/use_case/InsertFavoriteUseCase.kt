package com.example.newsapphilt.domain.use_case

import com.example.newsapphilt.data.local.ArticleEntity
import com.example.newsapphilt.domain.local.LocalNewsInterface
import javax.inject.Inject

class InsertFavoriteUseCase @Inject constructor(private val localNewsInterface: LocalNewsInterface) {
    suspend operator fun invoke(news: ArticleEntity) {
        localNewsInterface.insertFavoriteNews(news)
    }
}