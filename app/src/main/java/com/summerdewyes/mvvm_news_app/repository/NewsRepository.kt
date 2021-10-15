package com.summerdewyes.mvvm_news_app.repository

import com.summerdewyes.mvvm_news_app.api.RetrofitInstance
import com.summerdewyes.mvvm_news_app.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
}