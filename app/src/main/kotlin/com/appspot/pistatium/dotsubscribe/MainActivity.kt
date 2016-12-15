package com.appspot.pistatium.dotsubscribe

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.appspot.pistatium.dotsubscribe.adapters.ArticleAdapter
import com.appspot.pistatium.dotsubscribe.databinding.ActivityMainBinding
import com.appspot.pistatium.dotsubscribe.models.Article
import com.appspot.pistatium.dotsubscribe.models.ArticleModel
import com.appspot.pistatium.dotsubscribe.viewmodels.ContentViewModel
import java.util.*
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val content = ContentViewModel(applicationContext)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.contentViewModel = content

        ArticleModel().getLatest().subscribe {
            content.articles = ArrayList(it)
        }
    }
}

@BindingAdapter("app:articles")
fun RecyclerView.setArticles(articles: List<Article>?) {
    this.layoutManager = LinearLayoutManager(context)
    articles?.let {
        val adapter = ArticleAdapter(articles)
        this.adapter = adapter
    }
}
