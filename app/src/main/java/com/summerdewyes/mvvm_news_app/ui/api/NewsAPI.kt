package com.summerdewyes.mvvm_news_app.ui.api

import com.summerdewyes.mvvm_news_app.ui.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import com.summerdewyes.mvvm_news_app.BuildConfig

interface NewsAPI {
    
    @Headers(
        "X-Naver-Client-Id: " + BuildConfig.API_ID,
        "X-Naver-Client-Secret: "  + BuildConfig.API_SECRET
    )
    @GET("v1/search/book.json?&display=10&start=1")
    suspend fun getBreakingNews(
        @Query("query")
        breakingQuery: String = "헤드라인 뉴스"
    ): Response<NewsResponse>

    @GET("v1/search/book.json?&display=10&start=1")
    suspend fun getSearchNews(
        @Query("query")
        searchQuery: String
    ): Response<NewsResponse>




}