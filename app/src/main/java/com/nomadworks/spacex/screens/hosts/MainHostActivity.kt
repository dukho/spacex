package com.nomadworks.spacex.screens.hosts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.nomadworks.spacex.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_host)
        setupNavigation()
    }

    private fun getNavController(): NavController =
        Navigation.findNavController(this, R.id.nav_host_fragment)

    private fun setupNavigation() {
        NavigationUI.setupActionBarWithNavController(this, getNavController())
    }

    override fun onSupportNavigateUp(): Boolean {
        return getNavController().navigateUp()
    }
}