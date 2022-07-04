package com.example.newsapphilt.data

import com.example.newsapphilt.domain.network.ApiInterface
import com.example.newsapphilt.domain.network.NewsInterface
import dagger.Module
import javax.inject.Inject

class NewsInterfaceImpl
@Inject constructor
    (private val api: ApiInterface) : NewsInterface {
    override suspend fun getPopularNews(q: String) {
        api.getPopularNews(q = q)
    }
}