package com.example.newsapphilt.data.network

import com.example.newsapphilt.domain.model.NewsModel
import com.example.newsapphilt.domain.network.ApiInterface
import com.example.newsapphilt.domain.network.NewsInterface
import retrofit2.Response
import javax.inject.Inject

class NewsInterfaceImpl
@Inject constructor
    (private val api: ApiInterface) : NewsInterface {
    override suspend fun getPopularNews(): Response<NewsModel> {
        return api.getPopularNews()
    }
}