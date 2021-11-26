package com.example.covaxspotter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.covaxspotter.CountyApplication
import com.example.covaxspotter.R
import com.example.covaxspotter.databinding.ActivityMainBinding
import com.example.covaxspotter.viewmodel.MainViewModel
import com.example.covaxspotter.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(( application as CountyApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentContainer = supportFragmentManager.findFragmentById(R.id.myNavHost) as NavHostFragment
        navController = fragmentContainer.navController
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}