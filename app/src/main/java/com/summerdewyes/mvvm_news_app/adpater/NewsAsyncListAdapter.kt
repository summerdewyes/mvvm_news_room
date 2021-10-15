package com.summerdewyes.mvvm_news_app.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.summerdewyes.mvvm_news_app.databinding.ItemArticlePreviewBinding
import com.summerdewyes.mvvm_news_app.models.Article


class NewsAsyncListAdapter : RecyclerView.Adapter<NewsAsyncListAdapter.ItemRecyclerViewHolder>() {


    val differ = AsyncListDiffer(this, ItemDifferUtilCallback())

    inner class ItemRecyclerViewHolder(private val binding: ItemArticlePreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            //Glide.with(this).load(article.urlToImage).into(binding.ivArticleImage)
            binding.tvSource.text = article.source.name
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description
            binding.tvPublishedAt.text = article.publishedAt

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsAsyncListAdapter.ItemRecyclerViewHolder {

        val binding =
            ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemRecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ItemRecyclerViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
        holder.itemView.apply {
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