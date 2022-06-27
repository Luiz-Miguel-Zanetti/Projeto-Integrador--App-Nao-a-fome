package com.example.projetonothungry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.projetonothungry.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val navController by lazy {

        supportFragmentManager.findFragmentById(R.id.fragmentContainerView)!!.findNavController()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNavigation()

        //ToolBar Automatizada
        val navHostFragment = (supportFragmentManager.findFragmentById
            (binding.fragmentContainerView.id)) as NavHostFragment
        supportActionBar



        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

    }

    private fun setUpBottomNavigation() {
        with(binding.bottomNavigation){ setupWithNavController(navController) }
    }


}






