package com.example.android_random_movie_roulette.ui.movieresult.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.android_random_movie_roulette.R
import com.example.android_random_movie_roulette.databinding.FragmentMovieResultsBinding
import com.example.android_random_movie_roulette.repository.MoviesRepository
import com.example.android_random_movie_roulette.utils.Constants.Companion.IMAGE_BASE_URL
import com.example.android_random_movie_roulette.utils.Resource

class MovieResultFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentMovieResultsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_results, container, false)
        val repository = MoviesRepository()
        val viewModelFactory = activity?.let { MovieResultViewModelFactory(it.application, repository) }
        val movieResultsViewModel = viewModelFactory?.let { ViewModelProvider(this, it) }?.get(MovieResultViewModel::class.java)

        binding.movieResultsViewModel = movieResultsViewModel
        binding.lifecycleOwner = this
        movieResultsViewModel?.getRandomMovie()
        movieResultsViewModel?.results?.observe(viewLifecycleOwner, Observer { resource ->
            when(resource) {
                is Resource.Success -> {
                    resource.data?.let { movieResponse ->
                        // Show Randomed Movie result
                        binding.movieResultsProgressBar.visibility = View.GONE
                        binding.movieResultTitle.text = movieResponse.getOriginalTitleIfTitleNotFound()
                        binding.movieResultReleaseDateRunTime.text = movieResponse.getReleaseDateAndRuntime()
                        binding.movieResultGenres.text = movieResponse.getGenres()
                        binding.movieResultOverview.text = movieResponse.getFormattedOverview()
                        when {
                            movieResponse.posterPath.isNotBlank() -> {
                                Glide.with(requireContext()).load(IMAGE_BASE_URL + movieResponse.posterPath).into(binding.moviePoster)
                            }
                            else -> binding.moviePoster.visibility = View.GONE
                        }
                    }
                }
                is Resource.Error -> {
                    // Show Error screen
                }
                is Resource.Loading -> {
                    // Show Loading
                }
            }
        })

        return binding.root
    }
}