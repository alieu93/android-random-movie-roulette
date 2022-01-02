package com.example.android_random_movie_roulette.api

import com.example.android_random_movie_roulette.utils.Constants.Companion.BASE_URL
import com.example.android_random_movie_roulette.utils.Constants.Companion.IMAGE_BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInstance {
    companion object {
        private val moshi by lazy {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        val api = retrofit.create(MoviesApi::class.java)
    }
}