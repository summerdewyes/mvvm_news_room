package com.summerdewyes.mvvm_news_app.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.summerdewyes.mvvm_news_app.repository.NewsRepository

/**
 * 하나의 팩토리로 다양한 ViewModel 클래스를 관리할 수도 있고, 원치 않는 상황에 대해서 컨트롤 할 수 있습니다.
 * 파라미터를 소유하고 있는 ViewModel 객체의 인스턴스를 생성할 수 있습니다.
 */

class NewsViewModelProviderFactory(
    val app: Application,
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T
    }

}