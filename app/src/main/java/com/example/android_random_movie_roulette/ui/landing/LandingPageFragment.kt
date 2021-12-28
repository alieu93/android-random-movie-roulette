package com.example.android_random_movie_roulette.ui.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android_random_movie_roulette.R
import com.example.android_random_movie_roulette.databinding.FragmentLandingBinding

class LandingPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLandingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_landing, container, false)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = LandingPageViewModelFactory()

        val landingPageViewModel = ViewModelProvider(this, viewModelFactory)[LandingPageViewModel::class.java]
        binding.landingPageViewModel = landingPageViewModel
        binding.lifecycleOwner = this

        landingPageViewModel.navigateToMovieResult.observe(this, Observer {
            if (it == true) {
                this.findNavController().navigate(LandingPageFragmentDirections.actionLandingFragmentToMovieResultActivity())
                landingPageViewModel.resetNavigation()
            }
        })
        return binding.root
    }
}