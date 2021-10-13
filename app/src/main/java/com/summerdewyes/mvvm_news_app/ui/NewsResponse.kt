package com.summerdewyes.mvvm_news_app.ui

data class NewsResponse(
    val display: Int,
    val items: List<Item>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)