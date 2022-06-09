package com.example.projetonothungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetonothungry.adapter.ProdutoAdapter
import com.example.projetonothungry.databinding.FragmentCadastroProdutosBinding
import com.example.projetonothungry.databinding.FragmentListBinding
import com.example.projetonothungry.model.Produtos

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        var listaProdutos = listOf(

            Produtos(
                "Caneca",
                10,
                "Melhor caneca para beber café!",
                "Acessórios",
                3
            ),

            Produtos(
                "Camiseta",
                15,
                "Camiseta da Marvel",
                "Vestuário",
                5
            ),

            Produtos(
                "Boné",
                18,
                "Boné esportivo",
                "Vestuário",
                2
            )
        )

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //Configura o recycler view
        val bindingRecycler = binding.recyclerProdutos
        val adapter = ProdutoAdapter()
        bindingRecycler.adapter = adapter
        bindingRecycler.layoutManager = LinearLayoutManager(context)
        bindingRecycler.setHasFixedSize(true)
        adapter.setLista(listaProdutos)

        binding.fabAddProduto.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment_to_cadastroProdutosFragment)


        }

        return binding.root
    }

}


