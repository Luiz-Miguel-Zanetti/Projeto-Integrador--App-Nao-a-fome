package com.example.projetonothungry.model

class Categoria(var id:Long,
                var descricao:String?,
                var produtos:List<Produtos>?) {

    override fun toString(): String {
        return descricao!!
    }
}