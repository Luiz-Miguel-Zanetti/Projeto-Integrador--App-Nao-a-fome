package com.example.projetonothungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetonothungry.adapter.ProdutoAdapter
import com.example.projetonothungry.adapter.TaskClickListener
import com.example.projetonothungry.databinding.FragmentListBinding
import com.example.projetonothungry.model.Produtos

class ListFragment : Fragment(), TaskClickListener {

    private lateinit var binding: FragmentListBinding
    private val mainViewMoldel : MainViewMoldel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        mainViewMoldel.listProduto()

        //Configura o recycler view
        val bindingRecycler = binding.recyclerProdutos
        val adapter = ProdutoAdapter(this, mainViewMoldel, requireContext())
        bindingRecycler.adapter = adapter
        bindingRecycler.layoutManager = LinearLayoutManager(context)
        bindingRecycler.setHasFixedSize(true)


        binding.fabAddProduto.setOnClickListener {
            mainViewMoldel.produtoSelecionado = null

            findNavController().navigate(R.id.action_listFragment_to_cadastroProdutosFragment)


        }

        mainViewMoldel.myProdutoResponse.observe(viewLifecycleOwner){

                response ->

            if(response.body() != null) {
                adapter.setList(response.body()!!)

            }

        }

        return binding.root
    }

    override fun onTaskClickListener(produtos: Produtos) {
        mainViewMoldel.produtoSelecionado = produtos
        findNavController().navigate(R.id.action_listFragment_to_cadastroProdutosFragment)
    }

}


