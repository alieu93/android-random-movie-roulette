package com.example.android_random_movie_roulette.models

import com.squareup.moshi.Json

data class MovieResponseList (
    val results: MutableList<MovieResults>
)

data class MovieResults (
    val id: Int = 0,
    @Json(name = "release_date") val releaseDate: String = "",
    @Json(name = "original_title") val originalTitle: String = "",
    val title: String = "",
    @Json(name = "original_language") val originalLanguage: String = "",
    val overview: String = "",
    @Json(name = "vote_average") val averageVote: Double = Double.MIN_VALUE,
    @Json(name = "poster_path") val posterImagePath: String = ""
)