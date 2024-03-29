package com.example.mvvmnewsapp.repository

import com.example.mvvmnewsapp.data.api.RetrofitInstance
import com.example.mvvmnewsapp.data.local.ArticleDatabase
import com.example.mvvmnewsapp.data.model.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllAreticle()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}