package com.nomadworks.spacex.screens.hosts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nomadworks.spacex.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_host)
    }
}