package com.example.newsapphilt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ArticleEntity::class], // Tell the database the entries will hold data of this type
    version = 1
)

abstract class NewsDataBase : RoomDatabase() {
    abstract fun getDao(): NewsDao
}