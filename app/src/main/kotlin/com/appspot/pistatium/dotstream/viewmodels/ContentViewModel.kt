package com.appspot.pistatium.dotstream.viewmodels

import android.content.Context


interface ContentViewModelInterface {
    interface MainView {
        fun getContext(): Context
        fun loadData()
    }

    interface ViewModel {
        fun destroy()
    }
}

class ContentViewModel(val mainView: ContentViewModelInterface.MainView, val context: Context) : ContentViewModelInterface {
    val test = "test"
}