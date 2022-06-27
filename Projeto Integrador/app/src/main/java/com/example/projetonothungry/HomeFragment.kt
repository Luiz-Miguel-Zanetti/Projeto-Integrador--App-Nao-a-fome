package com.example.projetonothungry

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetonothungry.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers.Main

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.imageDoarNota.setOnClickListener{

           findNavController().navigate(R.id.action_homeFragment_to_carteiraFragment)
        }


        return binding.root

    }




    }

