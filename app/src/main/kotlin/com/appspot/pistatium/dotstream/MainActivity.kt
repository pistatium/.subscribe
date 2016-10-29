package com.appspot.pistatium.dotstream

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.appspot.pistatium.dotstream.databinding.ActivityMainBinding
import com.appspot.pistatium.dotstream.viewmodels.ContentViewModel
import com.appspot.pistatium.dotstream.viewmodels.ContentViewModelInterface

class MainActivity : AppCompatActivity(), ContentViewModelInterface.MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val content = ContentViewModel(this, applicationContext)
        binding.contentViewModel = content
    }

    override fun loadData() {

    }

    override fun getContext(): Context {
        return this
    }
}
