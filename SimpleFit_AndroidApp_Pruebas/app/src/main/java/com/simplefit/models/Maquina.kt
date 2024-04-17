package com.simplefit.models

import java.sql.Blob

data class Maquina (
    val maquinaid : Int,
    val nombre : String,
    val musculo : String,
    val imagen : Blob?,
    val descripcion : String
)
