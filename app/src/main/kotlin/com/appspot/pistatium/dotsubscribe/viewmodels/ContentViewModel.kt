package com.appspot.pistatium.dotsubscribe.viewmodels

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.appspot.pistatium.dotsubscribe.models.Article
import java.util.*



class ContentViewModel(val context: Context) : BaseObservable() {
    @Bindable
    var articles = ArrayList<Article>()
        set(value) {
            notifyPropertyChanged(BR.articles)
            field = value
        }
}
