package com.example.android_random_movie_roulette.repository

import com.example.android_random_movie_roulette.api.RetrofitInstance.Companion.api

class MoviesRepository {
    suspend fun getRandomMovies(page: String) = api.getDiscoverMovieList(page)
}