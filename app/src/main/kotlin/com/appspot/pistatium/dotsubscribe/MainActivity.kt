package com.appspot.pistatium.dotsubscribe

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.appspot.pistatium.dotsubscribe.adapters.ArticleAdapter
import com.appspot.pistatium.dotsubscribe.databinding.ActivityMainBinding
import com.appspot.pistatium.dotsubscribe.models.Article
import com.appspot.pistatium.dotsubscribe.viewmodels.ContentViewModel
import com.google.firebase.database.*
import java.util.*
import kotlin.concurrent.thread
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {


    private var binding: ActivityMainBinding by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val content = ContentViewModel(applicationContext)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.contentViewModel = content

        val database = FirebaseDatabase.getInstance()
        // TODO:
        val today = "20161210"
        val current = "173000"
        val latest_news = database.reference.child(today).child(current)
        latest_news.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val articles =  ArrayList<Article>()
                snapshot.children
                        .map { it.getValue(Article::class.java) }
                        .forEach { articles.add(it) }
                content.articles = articles
            }
            override fun onCancelled(p0: DatabaseError?) { }

        })
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
