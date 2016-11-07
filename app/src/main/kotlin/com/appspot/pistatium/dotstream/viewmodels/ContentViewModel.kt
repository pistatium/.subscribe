package com.appspot.pistatium.dotstream.viewmodels

import android.content.Context
import com.appspot.pistatium.dotstream.models.Article
import java.util.*



class ContentViewModel(val context: Context) {
    var test: String = "test"

    var articles = ArrayList<Article>()
}
