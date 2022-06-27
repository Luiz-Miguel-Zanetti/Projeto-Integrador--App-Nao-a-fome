package com.example.projetonothungry.api

import com.example.projetonothungry.model.Categoria
import com.example.projetonothungry.model.Produtos
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addProduto(produtos: Produtos): Response<Produtos> {
        return RetrofitInstance.api.addProduto(produtos)

    }

    suspend fun listProduto(): Response<List<Produtos>> {

        return RetrofitInstance.api.listProduto()

    }

    suspend fun updateProduto(produtos: Produtos):Response<Produtos>{
        return RetrofitInstance.api.updateProduto(produtos)
    }

    suspend fun deleteProduto(id:Long):Response<Produtos>{
        return RetrofitInstance.api.deleteProduto(id)
    }

}