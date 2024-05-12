package com.simplefit.data.services.rutina

data class RutinasApi (
    val rutinaid: Int,
    val titulo : String,
    val descripcion : String,
    val frecuencia : Int,
    val diasdescanso : Int,
    val dificultad : String
)