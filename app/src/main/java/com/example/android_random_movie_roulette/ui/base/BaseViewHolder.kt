package com.example.android_random_movie_roulette.ui.base

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(position: Int)
}
