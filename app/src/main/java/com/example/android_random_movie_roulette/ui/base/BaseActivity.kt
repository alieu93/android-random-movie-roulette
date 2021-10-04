package com.example.android_random_movie_roulette.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

abstract class BaseActivity : AppCompatActivity() {
    private val INTENT_KEY_ARG_DATA = "ARG_DATA"

    private lateinit var mViewModel: BaseViewModel

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initialize(savedInstanceState)
    }

    protected abstract fun initialize(state: Bundle?)

    protected fun <T : Serializable> getArgData(): T {
        return intent.getSerializableExtra(INTENT_KEY_ARG_DATA) as T
    }


}

