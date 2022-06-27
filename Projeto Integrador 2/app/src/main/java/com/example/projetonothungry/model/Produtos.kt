package com.example.projetonothungry.model

import android.widget.ImageView

data class Produtos(

    var id : Long,
    var nomeMarca : String,
    var descricao : String,
    var imagem : String,
    var quantidade : Int,
    var valor : Double,
    var categoria : Categoria


    ) {
}