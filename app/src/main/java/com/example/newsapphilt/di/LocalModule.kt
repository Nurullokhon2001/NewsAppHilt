package com.example.newsapphilt.di

import android.content.Context
import androidx.room.Room
import com.example.newsapphilt.data.local.LocalNewsInterfaceImpl
import com.example.newsapphilt.data.local.NewsDao
import com.example.newsapphilt.data.local.NewsDataBase
import com.example.newsapphilt.domain.local.LocalNewsInterface
import com.example.newsapphilt.domain.use_case.InsertFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        NewsDataBase::class.java,
        "news_db"
    ).build()

    @Singleton
    @Provides
    fun provideDao(db: NewsDataBase) = db.getDao()

    @Provides
    @Singleton
    fun provideInsertNewsCase(localNewsInterface: LocalNewsInterface) =
        InsertFavoriteUseCase(localNewsInterface)

    @Provides
    @Singleton
    fun provideLocalNews(dao: NewsDao): LocalNewsInterface = LocalNewsInterfaceImpl(dao)


}