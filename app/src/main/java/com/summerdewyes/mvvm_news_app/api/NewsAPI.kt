package com.summerdewyes.mvvm_news_app.api

import com.summerdewyes.mvvm_news_app.models.NewsResponse
import com.summerdewyes.mvvm_news_app.other.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsAPI {

    @Headers(
        "X-Naver-Client-Id: RnJ9HHV6ldcXy8Jk7gTp", /*+ BuildConfig.API_ID,*/
        "X-Naver-Client-Secret: SYMPZcPFQL"  /*+ BuildConfig.API_SECRET*/
    )
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "kr",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        countryCode: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>




}