package com.summerdewyes.mvvm_news_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.summerdewyes.mvvm_news_app.R
import com.summerdewyes.mvvm_news_app.databinding.ActivityNewsBinding
import com.summerdewyes.mvvm_news_app.db.ArticleDatabase
import com.summerdewyes.mvvm_news_app.repository.NewsRepository


class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root) // contentView에 등록


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        val navHostFragment= supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController= navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

    }
}