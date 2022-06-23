package com.example.projetonothungry.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetonothungry.MainViewMoldel
import com.example.projetonothungry.databinding.PrudutosListLayoutBinding
import com.example.projetonothungry.model.Produtos

class ProdutoAdapter(
    val taskClickListener: TaskClickListener,
    val mainViewMoldel: MainViewMoldel
) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {


    class ProdutoViewHolder(val binding : PrudutosListLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    private var listaProdutos = emptyList<Produtos>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {

        return ProdutoViewHolder(PrudutosListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {


        val produtos = listaProdutos[position]

        holder.binding.textNomeProduto.text = produtos.nomeMarca
        //holder.binding.imageProdutoAdapter.te
        holder.binding.textDescricaoProduto.text = produtos.descricao
        holder.binding.textQuantidadeDisponivelProduto.text = produtos.quantidade.toString()
        holder.binding.textCategoriaProduto.text = produtos.categoria.toString()
        holder.binding.textValorProduto.text = produtos.valor.toString()


        holder.itemView.setOnClickListener{
            taskClickListener.onTaskClickListener(produtos)
        }



    }

    override fun getItemCount(): Int {

        return listaProdutos.size

    }

    fun setLista(list: List<Produtos>){

        listaProdutos = list.sortedByDescending {it.id  }
        notifyDataSetChanged()

    }

}