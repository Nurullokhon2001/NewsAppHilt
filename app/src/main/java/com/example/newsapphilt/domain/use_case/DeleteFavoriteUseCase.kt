package com.example.newsapphilt.domain.use_case

import com.example.newsapphilt.domain.local.LocalNewsInterface

class DeleteFavoriteUseCase(private val localNewsInterface: LocalNewsInterface) {
    suspend operator fun invoke(id: Int) {
        localNewsInterface.deleteFavoriteNews(id)
    }
}