package com.summerdewyes.mvvm_news_app.adpater


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.summerdewyes.mvvm_news_app.databinding.ItemArticlePreviewBinding
import com.summerdewyes.mvvm_news_app.models.Article


/**
 * ListAdapter는 AsyncListDiffer의 wrapper 클래스로, RecyclerView.Adapter<VH>를 구현하고 있다.
 */

class NewsAdapter : ListAdapter<Article, NewsAdapter.ArticleViewHolder>(ItemDifferUtilCallback()) {

    private var onItemClickListener: ((Article) -> Unit)? = null

    inner class ArticleViewHolder(private val binding: ItemArticlePreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            Glide.with(binding.root).load(article.urlToImage).into(binding.ivArticleImage)
            binding.tvSource.text = article.source.name
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description
            binding.tvPublishedAt.text = article.publishedAt

            itemView.setOnClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder(
        ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

}




