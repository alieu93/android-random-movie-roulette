package com.example.android_random_movie_roulette.ui.landing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.android_random_movie_roulette.R
import com.example.android_random_movie_roulette.databinding.FragmentLandingBinding
import com.example.android_random_movie_roulette.ui.movieresult.MovieResultActivity

class LandingPageFragment : Fragment(R.layout.fragment_landing) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLandingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_landing, container, false)

        //TODO OnClickListener not working here despite binding initializing fine
        binding.spinRouletteButton.setOnClickListener {
            val intent = Intent(context, MovieResultActivity::class.java)
            startActivity(intent)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}