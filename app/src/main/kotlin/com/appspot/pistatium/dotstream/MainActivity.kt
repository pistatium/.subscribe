package com.appspot.pistatium.dotstream

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.appspot.pistatium.dotstream.databinding.ActivityMainBinding
import com.appspot.pistatium.dotstream.viewmodels.ContentViewModel

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val content = ContentViewModel()
    }
}
