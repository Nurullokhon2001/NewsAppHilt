package com.example.newsapphilt.presentation.main_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapphilt.data.NewsInterfaceImpl
import com.example.newsapphilt.domain.network.NewsInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVIewModel @Inject constructor(private val networkRepo: NewsInterface) : ViewModel() {
    fun getPopularNews(q: String) {
        viewModelScope.launch {
            networkRepo.getPopularNews(q)
        }
    }
}