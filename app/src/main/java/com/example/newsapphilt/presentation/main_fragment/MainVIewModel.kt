package com.example.newsapphilt.presentation.main_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapphilt.data.local.ArticleEntity
import com.example.newsapphilt.domain.model.NewsModel
import com.example.newsapphilt.domain.use_case.InsertFavoriteUseCase
import com.example.newsapphilt.domain.use_case.PopularNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainVIewModel @Inject constructor(
    private val popularNewsUseCase: PopularNewsUseCase,
    private val insertFavoriteUseCase: InsertFavoriteUseCase
) :
    ViewModel() {

    fun getPopularNews(): LiveData<Response<NewsModel>> {
        val newsDataList = MutableLiveData<Response<NewsModel>>()
        viewModelScope.launch {
            newsDataList.value = popularNewsUseCase.invoke()
            val model = popularNewsUseCase.invoke().body()!!.articles[0]
            insertFavoriteUseCase.invoke(
                ArticleEntity(
                    description = model.description,
                    publishedAt = model.publishedAt,
                    source = model.source.name,
                    title = model.title,
                    url = model.url,
                    urlToImage = model.urlToImage,
                )
            )
        }
        return newsDataList
    }
}