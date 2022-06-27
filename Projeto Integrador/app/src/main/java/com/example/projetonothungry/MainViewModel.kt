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
    private val repository: Repository
) : ViewModel() {

    var produtoSelecionado: Produtos? = null

    private var _myCategoriaResponse = MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> = _myCategoriaResponse

    private val _myProdutoResponse = MutableLiveData<Response<List<Produtos>>>()

    val myProdutoResponse: LiveData<Response<List<Produtos>>> = _myProdutoResponse

    fun listCategoria() {
        viewModelScope.launch {
            try {
                val response = repository.listCategoria()
                _myCategoriaResponse.value = response

            } catch (e: Exception) {
                Log.d("Erro!", e.message.toString())

            }
        }
    }

    fun addProduto(produtos: Produtos) {
        viewModelScope.launch {
            try {
                val response = repository.addProduto(produtos)
                Log.d("Erro aqui mesmo", response.body().toString())
                listProduto()

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())

            }
        }


    }

    fun listProduto() {

        viewModelScope.launch {
            try {

                val response = repository.listProduto()
                _myProdutoResponse.value = response

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())

            }

        }
    }

    fun updateProduto(produtos: Produtos) {
        viewModelScope.launch {
            try {
                repository.updateProduto(produtos)
                listProduto()
            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun deleteProduto(id: Long) {
        viewModelScope.launch {
            try {
                repository.deleteProduto(id)
                listProduto()
            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }
}