package com.appspot.pistatium.dotstream.adapters

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import com.appspot.pistatium.dotstream.models.Article

@BindingAdapter("articles")
fun setAdapter(recycleView: RecyclerView, articles: List<Article>) {
    val adapter = ArticleAdapter(articles)
}

class ArticleAdapter(val articles: List<Article>)