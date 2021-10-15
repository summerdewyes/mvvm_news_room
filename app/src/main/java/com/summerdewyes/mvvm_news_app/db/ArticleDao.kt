package com.summerdewyes.mvvm_news_app.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.summerdewyes.mvvm_news_app.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllItems(): LiveData<List<Article>>

    @Delete
    suspend fun deleteItem(item: Article)
}