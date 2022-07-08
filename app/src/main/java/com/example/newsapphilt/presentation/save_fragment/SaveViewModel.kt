package com.example.newsapphilt.presentation.save_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapphilt.data.local.ArticleEntity
import com.example.newsapphilt.domain.use_case.DeleteFavoriteUseCase
import com.example.newsapphilt.domain.use_case.GetAllFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveViewModel @Inject constructor(
    private val getAllFavoriteUseCase: GetAllFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {

    fun getFavorites(): LiveData<List<ArticleEntity>> {
        val favorites = MutableLiveData<List<ArticleEntity>>()
        viewModelScope.launch {
            favorites.value = getAllFavoriteUseCase.invoke()
        }
        return favorites
    }

    fun deleteFavorite(url: String) {

        viewModelScope.launch {
            deleteFavoriteUseCase.invoke(url)
        }

    }
}