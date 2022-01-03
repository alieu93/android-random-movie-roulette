package com.example.android_random_movie_roulette.ui.movieresult.fragment

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_random_movie_roulette.models.MovieResponse
import com.example.android_random_movie_roulette.models.MovieResponseList
import com.example.android_random_movie_roulette.repository.MoviesRepository
import com.example.android_random_movie_roulette.utils.Constants.Companion.RANDOM_MOVIE_LOWER_BOUND
import com.example.android_random_movie_roulette.utils.Constants.Companion.RANDOM_MOVIE_UPPER_BOUND
import com.example.android_random_movie_roulette.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class MovieResultViewModel(private val application: Application,
                           private val repository: MoviesRepository) : ViewModel() {


    private var _results = MutableLiveData<Resource<MovieResponse>>()
    val results: LiveData<Resource<MovieResponse>> = _results


    fun getRandomMovie() = viewModelScope.launch {
        var retryCount = 0
        _results.postValue(Resource.Loading())
        Log.d("RandomMovie", "getRandomMovie running")
        try {
            if (hasInternetConnection()) {
                var randomMovieList = getRandomMovieQuery()

                if (randomMovieList.code() == 404 && retryCount < 3) {
                    retryCount++
                    randomMovieList = getRandomMovieQuery()
                }
                _results.postValue(handleRandomMovieListResponse(randomMovieList))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _results.postValue(Resource.Error("IOException has occurred"))
                else -> _results.postValue(Resource.Error(t.stackTraceToString()))
            }
        }
    }

    private suspend fun getRandomMovieQuery() : Response<MovieResponse> {
        return repository.getRandomMovies((RANDOM_MOVIE_LOWER_BOUND..RANDOM_MOVIE_UPPER_BOUND).random().toString())
    }

    private fun handleRandomMovieListResponse(responseList: Response<MovieResponse>) : Resource<MovieResponse> {
        if (responseList.isSuccessful) {
            responseList.body()?.let { resultList ->
                return Resource.Success(resultList)
            }
        }
        return Resource.Error(responseList.message())
    }


    private fun hasInternetConnection(): Boolean {
        val connectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
        else {
            connectivityManager.activeNetworkInfo?.run {
                return when(type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    else -> true
                }
            }
        }
        return false
    }
}