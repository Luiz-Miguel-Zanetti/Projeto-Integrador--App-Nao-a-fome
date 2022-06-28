package com.example.projetonothungry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projetonothungry.databinding.FragmentCadastroProdutosBinding
import com.example.projetonothungry.model.Categoria
import com.example.projetonothungry.model.Produtos

class CadastroProdutosFragment : Fragment() {


    private lateinit var binding: FragmentCadastroProdutosBinding
    private val mainViewMoldel: MainViewMoldel by activityViewModels()
    private var categoriaSelecionada = 0L
    private var produtoSelecionado: Produtos? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCadastroProdutosBinding.inflate(layoutInflater, container, false)

        carregarDados()

        mainViewMoldel.listCategoria()

        configuraBotaoQntd()



        mainViewMoldel.myCategoriaResponse.observe(viewLifecycleOwner) { response ->
            Log.d("Requisição", response.body().toString())
            configuraSpinnerCategoria(response.body())
        }



        binding.buttonCadastrar.setOnClickListener {

            inserirProduto()

        }






        return binding.root
    }


    private fun validarCampos(


        nomeProduto: String,
        imagemProduto: String,
        descriçãoProdutos: String,
        valorProduto: String,
        quantidadeProduto: String
    )
            : Boolean {

        return !((nomeProduto == "" || nomeProduto.length < 3 || nomeProduto.length > 24) ||
                (imagemProduto == "") ||
                (descriçãoProdutos == "" || descriçãoProdutos.length < 10 || descriçãoProdutos.length > 30) ||
                (valorProduto.toInt() < 0 ))
                (quantidadeProduto == "" || quantidadeProduto.toInt() < 0 )


    }

    private fun inserirProduto() {
        val nomeProduto = binding.editNomeProduto.text.toString()
        val imagemProduto = binding.editImagemProduto.text.toString()
        val descricao = binding.editDescriOProduto.text.toString()
        val categoriaProduto = Categoria(categoriaSelecionada, null, null)
        val quantidadeProduto = binding.editQuantidadeProduto.text.toString()
        val valorProduto = binding.editValorProduto.text.toString()

        if (validarCampos(
                nomeProduto,
                imagemProduto, descricao, valorProduto, quantidadeProduto
            )
        ) { val salvar:String
            if(produtoSelecionado != null){
                salvar = "Produto atualizado com sucesso!"
                        val produtos = Produtos(produtoSelecionado?.id!!,
                    nomeProduto,
                    descricao,
                    imagemProduto,
                    quantidadeProduto.toInt(),
                    valorProduto.toDouble(),
                    categoriaProduto
                )
                mainViewMoldel.updateProduto(produtos)
            } else {
                salvar =" Produto cadastrado com sucesso!"
                val produtos = Produtos(0,
                        nomeProduto,
                        descricao,
                        imagemProduto,
                        quantidadeProduto.toInt(),
                        valorProduto.toDouble(),
                        categoriaProduto
                    )
                    mainViewMoldel.addProduto(produtos)
            }


            Toast.makeText(context, salvar, Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_cadastroProdutosFragment_to_listFragment)


        } else {

            Toast.makeText(context, "Preencha os campos corretamente", Toast.LENGTH_LONG).show()


        }


    }

    private fun configuraSpinnerCategoria(listCategoria: List<Categoria>?) {

        if (listCategoria != null) {
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                listCategoria
            )

            binding.spinnerCategoria.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selected = binding.spinnerCategoria.selectedItem as Categoria

                        categoriaSelecionada = selected.id
                        binding.editImagemCategoria.setText("" + selected)

                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }


        }

    }

    private fun carregarDados() {
        produtoSelecionado = mainViewMoldel.produtoSelecionado
        if (produtoSelecionado != null) {
            binding.editNomeProduto.setText(produtoSelecionado?.nomeMarca)
            binding.editDescriOProduto.setText(produtoSelecionado?.descricao)
            binding.editQuantidadeProduto.setText(produtoSelecionado?.quantidade!!.toString())
            binding.editValorProduto.setText(produtoSelecionado?.valor!!.toString())
        }
    }


    fun configuraBotaoQntd(){

        var cont = 0
        var cont2 = 0

        binding.buttonAdd.setOnClickListener {

            cont++
           binding.editQuantidadeProduto.setText("" + cont)

        }

        binding.buttonAdd2.setOnClickListener {

            cont2++
            binding.editValorProduto.setText("" + cont2)


        }

        binding.buttonDmn.setOnClickListener {

            cont--
            binding.editQuantidadeProduto.setText("" + cont)


        }

        binding.buttonDmn2.setOnClickListener {

            cont2--
            binding.editValorProduto.setText("" + cont2)


        }


    }




    }






