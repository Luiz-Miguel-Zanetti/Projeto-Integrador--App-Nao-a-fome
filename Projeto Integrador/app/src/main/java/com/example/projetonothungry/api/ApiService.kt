package com.example.projetonothungry.api

import com.example.projetonothungry.model.Categoria
import com.example.projetonothungry.model.Produtos
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("produtos")
    suspend fun addProduto(@Body produtos: Produtos) : Response<Produtos>

    @GET("produtos")
    suspend fun listProduto() : Response<List<Produtos>>


}