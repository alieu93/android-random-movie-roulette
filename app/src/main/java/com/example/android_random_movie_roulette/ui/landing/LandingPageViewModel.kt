package com.example.android_random_movie_roulette.ui.landing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LandingPageViewModel : ViewModel() {
    private val _navigateToMovieResult = MutableLiveData<Boolean?>()

    val navigateToMovieResult: LiveData<Boolean?>
        get() = _navigateToMovieResult

    fun resetNavigation() {
        _navigateToMovieResult.value = false
    }
    fun navigateToMovieResultActivity() {
        _navigateToMovieResult.value = true
    }
}