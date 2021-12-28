package com.example.android_random_movie_roulette.ui.movieresult.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_random_movie_roulette.ui.landing.LandingPageViewModel
import java.lang.IllegalArgumentException

class MovieResultViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieResultViewModel::class.java)) {
            return MovieResultViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}