package com.appspot.pistatium.dotstream

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.appspot.pistatium.dotstream.adapters.ArticleAdapter
import com.appspot.pistatium.dotstream.databinding.ActivityMainBinding
import com.appspot.pistatium.dotstream.models.Article
import com.appspot.pistatium.dotstream.viewmodels.ContentViewModel
import com.appspot.pistatium.dotstream.viewmodels.ContentViewModelInterface
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), ContentViewModelInterface.MainView {

    private var binding: ActivityMainBinding by Delegates.notNull<>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val content = ContentViewModel(this, applicationContext)
        binding.contentViewModel = content
    }

    override fun loadData(articles: Article) {
        binding.contentViewModel.articles = articles

    }

    override fun getContext(): Context {
        return this
    }
}

@BindingAdapter("articles")
fun setAdapter(recycleView: RecyclerView, articles: List<Article>) {
    val adapter = ArticleAdapter(articles)
    recycleView.adapter = adapter
}