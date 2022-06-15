package com.example.projetonothungry

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetonothungry.api.Repository
import com.example.projetonothungry.model.Categoria
import com.example.projetonothungry.model.Produtos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewMoldel @Inject constructor(
    private val repository: Repository)
    :ViewModel(){
  private var _myCategoriaResponse = MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse : LiveData<Response<List<Categoria>>> = _myCategoriaResponse

    // private val _myProdutoResponse =MutableLiveData<Response<List<Produtos>>>()

    // val myProdutoResponse : LiveData<Response<List<Produtos>>> = _myProdutoResponse

   fun listCategoria(){
       viewModelScope.launch {
           try{
             val response = repository.listCategoria()
                 _myCategoriaResponse.value = response

           }catch(e: Exception) {
               Log.d("Erro!", e.message.toString())

           }
       }
   }

}
