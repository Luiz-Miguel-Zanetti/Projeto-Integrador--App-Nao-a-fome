package com.example.projetonothungry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projetonothungry.databinding.FragmentCadastroProdutosBinding

class CadastroProdutosFragment : Fragment() {


    private lateinit var binding: FragmentCadastroProdutosBinding

    private val mainViewMoldel: MainViewMoldel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = FragmentCadastroProdutosBinding.inflate(layoutInflater, container, false)

        mainViewMoldel.listCategoria()
        mainViewMoldel.myCategoriaResponse.observe(viewLifecycleOwner){
            response -> Log.d("Requisição", response.body().toString())
        }
        binding.buttonCadastrar.setOnClickListener {
            inserirProduto()

        }






        return binding.root
    }




   private fun validarCampos(


        nomeProduto: String,
        categoria: String,
        imagemProduto: String,
        valorProduto: String,
        quantidadeProduto: String
    )
            : Boolean {

        return !((nomeProduto == "" || nomeProduto.length < 3 || nomeProduto.length > 24 ) ||
                (categoria == "") ||
                (imagemProduto == "") ||
                (quantidadeProduto == "" || quantidadeProduto.isEmpty()) ||
                (valorProduto == "")
                        //valorProduto > 3.toString())

                )


    }

    private fun inserirProduto(){

        val nomeProduto = binding.editNomeProduto.text.toString()
        val categoriaProduto = binding.editCategoriaProduto.text.toString()
        val imagemProduto = binding.editImagemProduto.text.toString()
        val quantidadeProduto = binding.editQuantidadeProduto.text.toString()
        val valorProduto = binding.editValorProduto.text.toString()

        if ( validarCampos(nomeProduto, categoriaProduto, imagemProduto, quantidadeProduto, valorProduto) ){

            Toast.makeText(context, "Produto cadastrado com sucesso!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_cadastroProdutosFragment_to_listFragment)


        }else{

            Toast.makeText(context, "Preencha os campos corretamente", Toast.LENGTH_LONG ).show()


        }


}


}