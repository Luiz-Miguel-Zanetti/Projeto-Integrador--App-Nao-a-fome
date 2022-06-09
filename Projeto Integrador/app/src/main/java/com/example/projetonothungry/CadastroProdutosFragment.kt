package com.example.projetonothungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.projetonothungry.databinding.FragmentCadastroProdutosBinding

class CadastroProdutosFragment : Fragment() {


    private lateinit var binding: FragmentCadastroProdutosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCadastroProdutosBinding.inflate(layoutInflater, container, false)
        binding.buttonCadastrar.setOnClickListener {

            findNavController().navigate(R.id.action_cadastroProdutosFragment_to_listFragment)

        }


        return binding.root
    }


}