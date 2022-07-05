package com.example.newsapphilt.domain.use_case

import com.example.newsapphilt.data.local.ArticleEntity
import com.example.newsapphilt.domain.local.LocalNewsInterface

class GetAllFavoriteUseCase(private val localNewsInterface: LocalNewsInterface) {
    suspend operator fun invoke(): List<ArticleEntity> {
        return localNewsInterface.getFavoriteNews()
    }
}