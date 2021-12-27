package com.example.android_random_movie_roulette.ui.landing

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LandingPageViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LandingPageViewModel::class.java)) {
            return LandingPageViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}