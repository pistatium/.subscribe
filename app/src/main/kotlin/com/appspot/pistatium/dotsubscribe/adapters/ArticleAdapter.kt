package com.appspot.pistatium.dotsubscribe.adapters

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
import com.appspot.pistatium.dotsubscribe.R
import com.appspot.pistatium.dotsubscribe.models.Article


class ArticleAdapter(val articles: List<Article>): RecyclerView.Adapter<ArticleAdapter.Companion.ItemViewHolder>() {
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.setVariable(BR.article, article)
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