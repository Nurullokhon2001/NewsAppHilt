package com.example.newsapphilt.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(newsModel: ArticleEntity)

    @Query("Select * from NewsTable")
    suspend fun getAllData(): List<ArticleEntity>

    @Query("Delete from NewsTable Where url = :url")
    suspend fun deleteFavoriteNews(url: String)

}