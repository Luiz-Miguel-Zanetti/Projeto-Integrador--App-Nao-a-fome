package com.example.projetonothungry.adapter

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.projetonothungry.databinding.FragmentListBinding
import com.example.projetonothungry.databinding.PrudutosListLayoutBinding
import com.example.projetonothungry.model.Produtos

class ProdutoAdapter : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {


    class ProdutoViewHolder(val binding : PrudutosListLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    private var listaProdutos = emptyList<Produtos>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {

        return ProdutoViewHolder(PrudutosListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {

        var layout = listaProdutos[position]

        holder.binding.textNomeProduto.text = layout.nome
        holder.binding.textDescricaoProduto.text = layout.descrição
        holder.binding.textValorProduto.text = layout.valor.toString()
        holder.binding.textCategoriaProduto.text = layout.categoria
        holder.binding.textQuantidadeDisponivelProduto.text = layout.quantidadeDisponivel.toString()




    }

    override fun getItemCount(): Int {

        return listaProdutos.size

    }

    fun setLista(list: List<Produtos>){

        listaProdutos = list
        notifyDataSetChanged()

    }

}