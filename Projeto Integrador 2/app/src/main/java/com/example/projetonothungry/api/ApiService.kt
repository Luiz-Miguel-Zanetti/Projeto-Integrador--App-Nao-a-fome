package com.example.projetonothungry.api

import com.example.projetonothungry.model.Categoria
import com.example.projetonothungry.model.Produtos
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("produtos")
    suspend fun addProduto(@Body produtos: Produtos): Response<Produtos>

    @GET("produtos")
    suspend fun listProduto(): Response<List<Produtos>>

    @PUT("produtos")
    suspend fun updateProduto(@Body produtos: Produtos): Response<Produtos>

    @DELETE("produtos/{id}")
    suspend fun deleteProduto(@Path ("id") id : Long): Response<Produtos>
}