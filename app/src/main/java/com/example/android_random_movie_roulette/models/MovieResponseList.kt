package com.example.android_random_movie_roulette.models

import com.squareup.moshi.Json

data class MovieResponseList (
    val results: MutableList<MovieResults>
)

data class MovieResults (
    val id: Int,
    @Json(name = "release_date") val releaseDate: String,
    @Json(name = "original_title") val originalTitle: String,
    val title: String,
    @Json(name = "original_language") val originalLanguage: String,
    val overView: String,
    @Json(name = "vote_average") val averageVote: Double,
    @Json(name = "poster_path") val posterImagePath: String
)