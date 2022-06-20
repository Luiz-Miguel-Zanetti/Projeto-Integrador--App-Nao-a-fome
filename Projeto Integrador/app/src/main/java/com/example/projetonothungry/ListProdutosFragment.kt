package com.example.projetonothungry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetonothungry.adapter.ProdutoAdapter
import com.example.projetonothungry.databinding.FragmentCadastroProdutosBinding
import com.example.projetonothungry.databinding.FragmentListBinding
import com.example.projetonothungry.model.Produtos

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val mainViewMoldel : MainViewMoldel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        mainViewMoldel.listProduto()





        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //Configura o recycler view
        val bindingRecycler = binding.recyclerProdutos
        val adapter = ProdutoAdapter()
        bindingRecycler.adapter = adapter
        bindingRecycler.layoutManager = LinearLayoutManager(context)
        bindingRecycler.setHasFixedSize(true)


        binding.fabAddProduto.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment_to_cadastroProdutosFragment)


        }

        mainViewMoldel.myProdutoResponse.observe(viewLifecycleOwner){

                response ->

            if(response.body() != null) {
                adapter.setLista(response.body()!!)

            }

        }

        return binding.root
    }

}


