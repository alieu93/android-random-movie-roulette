package com.example.android_random_movie_roulette.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    private val mIsLoading = ObservableBoolean()
}
