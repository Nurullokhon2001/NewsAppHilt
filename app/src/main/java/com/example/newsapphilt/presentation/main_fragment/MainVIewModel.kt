package com.example.newsapphilt.presentation.main_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapphilt.domain.use_case.PopularNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVIewModel @Inject constructor(private val popularNewsUseCase: PopularNewsUseCase) :
    ViewModel() {
    fun getPopularNews(q: String) {
        viewModelScope.launch {
            popularNewsUseCase.invoke(q)
        }
    }
}