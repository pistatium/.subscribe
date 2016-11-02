package com.appspot.pistatium.dotstream.viewmodels

import android.content.Context
import com.appspot.pistatium.dotstream.models.Article
import java.util.*



class ContentViewModel(val context: Context) {
    var test: String = ""

    var articles = ArrayList<Article>()

    init {
        articles.add(Article(title="test", url="https://google.com"))
        articles.add(Article(title="test2", url="https://google.com"))
        articles.add(Article(title="test3", url="https://google.com"))
        articles.add(Article(title="test4", url="https://google.com"))
        articles.add(Article(title="test5", url="https://google.com"))
    }
}
