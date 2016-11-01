package com.appspot.pistatium.dotstream.viewmodels

import android.content.Context
import com.appspot.pistatium.dotstream.models.Article
import java.util.*


interface ContentViewModelInterface {
    interface MainView {
        fun getContext(): Context
        fun loadData(articles: List<Article>)
    }

    interface ViewModel {
        fun destroy()
    }
}

class ContentViewModel(val mainView: ContentViewModelInterface.MainView, val context: Context) {
    var test: String = ""

    init {
        val articles = ArrayList<Article>()
        articles.add(Article(title="test", url="https://google.com"))
        articles.add(Article(title="test2", url="https://google.com"))
        articles.add(Article(title="test3", url="https://google.com"))
        articles.add(Article(title="test4", url="https://google.com"))
        articles.add(Article(title="test5", url="https://google.com"))
        mainView.loadData(articles)
    }
}