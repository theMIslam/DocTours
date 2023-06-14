package com.example.doctour.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.doctour.R
import com.example.doctour.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navView: BottomNavigationView = binding.bottomNavView
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment2 ->{
                    navView.visibility = View.VISIBLE
                }
                R.id.categoryFragment2 ->{
                    navView.visibility = View.VISIBLE
                }
                R.id.fragment_profile ->{
                    navView.visibility = View.VISIBLE
                }







                else -> {
                    navView.visibility = View.GONE
                }
            }
        }
    }
}
