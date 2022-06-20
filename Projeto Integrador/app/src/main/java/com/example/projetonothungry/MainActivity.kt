package com.example.projetonothungry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
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


    }


    private fun setUpBottomNavigation() {
        with(binding.bottomNavigation){ setupWithNavController(navController) }
    }


}






