package com.example.newsapphilt.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapphilt.domain.model.Source

@Entity(tableName = "NewsTable")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val description: String,
    val publishedAt: String,
    val source: String,
    val title: String,
    val url: String,
    val urlToImage: String
)