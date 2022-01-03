package com.example.android_random_movie_roulette.models

import com.squareup.moshi.Json

data class MovieResponse (
    val id: Int = 0,
    val genres: MutableList<MovieGenre>,
    @Json(name = "imdb_db") val imdbId: String = "",
    @Json(name = "original_language") val originalLanguage: String = "",
    @Json(name = "original_title") val originalTitle: String = "",
    @Json(name = "title") val title: String = "",
    val overview: String = "",
    @Json(name = "poster_path") val posterPath: String = "",
    @Json(name = "release_date") val releaseDate: String = "",
    @Json(name = "spoken_languages") val spokenLanguages: MutableList<MovieSpokenLanguage>,
    @Json(name = "vote_average") val voteAverage: Double = Double.MIN_VALUE,
    val runtime: Int = 0
) {

    fun getOriginalTitleIfTitleNotFound(): String {
        if (title.isEmpty()) {
            return originalTitle
        }
        return title
    }

    fun getReleaseDateAndRuntime(): String {
        return "$releaseDate | $runtime minutes"
    }

    fun getFormattedOverview() : String {
        return "Overview:\n$overview"
    }

    fun getGenres(): String {
        return genres.joinToString(separator = " | ") { it.genreName }
    }
}

data class MovieGenre(@Json(name = "id") val genreId: Int = 0, @Json(name = "name") val genreName: String = "")

data class MovieSpokenLanguage(@Json(name = "english_name") val englishName: String = "", @Json(name = "name") val spokenName: String = "")