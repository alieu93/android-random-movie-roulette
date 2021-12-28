package com.example.android_random_movie_roulette.ui.landing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LandingPageViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LandingPageViewModel::class.java)) {
            return LandingPageViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}