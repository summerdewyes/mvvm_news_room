package com.summerdewyes.mvvm_news_app.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.summerdewyes.mvvm_news_app.R
import com.summerdewyes.mvvm_news_app.models.Article


/*
/**
 * ListAdapter는 AsyncListDiffer의 wrapper 클래스로, RecyclerView.Adapter<VH>를 구현하고 있다.
 */

class NewsAdapter : ListAdapter<Article, NewsAdapter.ItemViewHolder>(ItemDifferUtilCallback()) {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val article = currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)
            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt
            setOnClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }


}

 */


