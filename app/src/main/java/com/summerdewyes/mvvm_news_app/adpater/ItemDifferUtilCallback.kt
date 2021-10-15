package com.summerdewyes.mvvm_news_app.adpater

import androidx.recyclerview.widget.DiffUtil
import com.summerdewyes.mvvm_news_app.models.Article

/**
 * DiffUtil은 기존의 데이터 리스트와 교체할 데이터 리스트를 비교해서 실질적으로 업데이트가 필요한 아이템들을 추려낸다.
 * -> AsyncListDiffer DiffUtil을 더 단순하게 사용할 수 있게 해주는 클래스다. 자체적으로 멀티 쓰레드에 대한 처리.
 * ->
 */
class ItemDifferUtilCallback: DiffUtil.ItemCallback<Article>() {

    /**
     * 두 아이템이 동일한 아이템인지 체크한다.
     */
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    /**
     * 두 아이템이 동일한 내용물을 가지고 있는지 체크한다, areItemsTheSame()가 true일 때만 호출.
     */
    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}