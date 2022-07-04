package com.example.newsapphilt.domain.use_case

import com.example.newsapphilt.domain.model.NewsModel
import com.example.newsapphilt.domain.network.NewsInterface
import retrofit2.Response
import javax.inject.Inject

class PopularNewsUseCase @Inject constructor(private val networkRepo: NewsInterface) {
    suspend operator fun invoke(): Response<NewsModel> {
        return networkRepo.getPopularNews()
    }
}