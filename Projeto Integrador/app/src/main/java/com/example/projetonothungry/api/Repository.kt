package com.example.projetonothungry.api

import com.example.projetonothungry.model.Categoria
import retrofit2.Response

class Repository  {
suspend fun listCategoria():Response<List<Categoria>>{

    return RetrofitInstance.api.listCategoria()
}
}