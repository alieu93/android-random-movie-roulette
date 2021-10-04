package com.example.android_random_movie_roulette.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_random_movie_roulette.R
import com.example.android_random_movie_roulette.ui.base.BaseActivity
import com.example.android_random_movie_roulette.ui.main.MainAdapter
import com.example.android_random_movie_roulette.ui.main.MainViewHolder

class MainActivity : BaseActivity() {
    private lateinit var mMainViewHolder: MainViewHolder
    private lateinit var mAdapter : MainAdapter

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initialize(state: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

    }
}