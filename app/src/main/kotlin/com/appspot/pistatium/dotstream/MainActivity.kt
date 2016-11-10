package com.appspot.pistatium.dotstream

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.appspot.pistatium.dotstream.adapters.ArticleAdapter
import com.appspot.pistatium.dotstream.databinding.ActivityMainBinding
import com.appspot.pistatium.dotstream.models.Article
import com.appspot.pistatium.dotstream.viewmodels.ContentViewModel
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {


    private var binding: ActivityMainBinding by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val content = ContentViewModel(applicationContext)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.contentViewModel = content
        content.articles.add(Article(title="test", url="https://google.com"))
        content.articles.add(Article(title="test", url="https://google.com"))
        content.articles.add(Article(title="test", url="https://google.com"))
        binding.notifyPropertyChanged(BR.contentViewModel)
    }
}

@BindingAdapter("app:articles")
fun RecyclerView.setArticles(articles: List<Article>?) {
    Log.d("Binding", "Called setAdapter")
    Log.d("Binding", "a: {$articles}")
    this.layoutManager = LinearLayoutManager(context)
    articles?.let {
        val adapter = ArticleAdapter(articles)
        this.adapter = adapter
    }
}
