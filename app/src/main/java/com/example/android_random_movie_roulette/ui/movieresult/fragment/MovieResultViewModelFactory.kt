package com.example.android_random_movie_roulette.ui.movieresult.fragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_random_movie_roulette.repository.MoviesRepository
import com.example.android_random_movie_roulette.ui.landing.LandingPageViewModel
import java.lang.IllegalArgumentException

class MovieResultViewModelFactory(
    private val application: Application,
    private val repository: MoviesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieResultViewModel::class.java)) {
            return MovieResultViewModel(application, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}