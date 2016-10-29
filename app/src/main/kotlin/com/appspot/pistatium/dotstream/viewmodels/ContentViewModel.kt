package com.appspot.pistatium.dotstream.viewmodels

import android.content.Context
import com.appspot.pistatium.dotstream.BuildConfig


interface ContentViewModelInterface {
    interface MainView {
        fun getContext(): Context
        fun loadData()
    }

    interface ViewModel {
        fun destroy()
    }
}

class ContentViewModel(val mainView: ContentViewModelInterface.MainView, val context: Context) {
    var test: String = ""
    init {
        test = BuildConfig.TEST
    }
}