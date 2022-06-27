package com.example.projetonothungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetonothungry.databinding.FragmentHomeBinding
import com.example.projetonothungry.databinding.FragmentPersonBinding

class PersonFragment : Fragment() {
    private lateinit var binding: FragmentPersonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = FragmentPersonBinding.inflate(layoutInflater, container, false)


        return binding.root

    }


            }