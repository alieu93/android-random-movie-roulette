package com.example.android_random_movie_roulette.api

import com.example.android_random_movie_roulette.models.MovieResponse
import com.example.android_random_movie_roulette.models.MovieResponseList
import com.example.android_random_movie_roulette.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/{movieId}")
    suspend fun getRandomMovie(
        @Path("movieId") movieId: String,
        @Query("api_key") key: String = API_KEY): Response<MovieResponse>
}