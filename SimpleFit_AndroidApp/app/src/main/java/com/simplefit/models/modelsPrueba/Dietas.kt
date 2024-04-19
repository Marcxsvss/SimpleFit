package com.simplefit.models.modelsPrueba

data class Dietas(
    val dietaid : Int,
    val descripcion : String,
    val nombre : String,
    val objetivo : String,
    val calorias : Int,
    val intolerancia : String?
)