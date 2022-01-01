package com.example.android_random_movie_roulette.ui.movieresult.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android_random_movie_roulette.R
import com.example.android_random_movie_roulette.databinding.FragmentMovieResultsBinding

class MovieResultFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentMovieResultsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_results, container, false)
        val viewModelFactory = MovieResultViewModelFactory()

        val movieResultsViewModel = ViewModelProvider(this, viewModelFactory)[MovieResultViewModel::class.java]
        binding.movieResultsViewModel = movieResultsViewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}