package com.example.mvvmnewsapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmnewsapp.data.model.Article

interface ArticleDao {
    // onConflict this work when you have two same news post make a replace
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllAreticle(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}