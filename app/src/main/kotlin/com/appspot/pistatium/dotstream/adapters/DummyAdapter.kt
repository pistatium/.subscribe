package com.appspot.pistatium.dotstream.adapters

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import com.android.databinding.library.baseAdapters.BR
import com.appspot.pistatium.dotstream.R
import com.appspot.pistatium.dotstream.models.Article

@BindingAdapter("articles")
fun setAdapter(recycleView: RecyclerView, articles: List<Article>) {
    val adapter = ArticleAdapter(articles)
}


class ArticleAdapter(val articles: List<Article>): RecyclerView.Adapter<ArticleAdapter.Companion.ItemViewHolder>() {
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val article = articles.get(position)
        holder.binding.setVariable(BR.contentViewModel, article)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_cell, parent, false)
        return ItemViewHolder(view)
    }

    companion object {
        class ItemViewHolder(v: View): RecyclerView.ViewHolder(v) {
            val binding: ViewDataBinding = DataBindingUtil.bind(v)
        }
    }
}