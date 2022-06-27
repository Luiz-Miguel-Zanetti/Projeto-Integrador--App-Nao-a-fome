package com.example.projetonothungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetonothungry.databinding.FragmentCarteiraBinding


class CarteiraFragment : Fragment() {

    private lateinit var binding: FragmentCarteiraBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCarteiraBinding.inflate(layoutInflater, container, false)

        

        return binding.root
    }

}