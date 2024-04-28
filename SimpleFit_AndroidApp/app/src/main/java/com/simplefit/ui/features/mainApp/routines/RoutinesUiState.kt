package com.simplefit.ui.features.mainApp.routines

import com.simplefit.models.Rutinas

data class RoutinesUiState(
    val rutinaid: Int,
    val titulo : String,
    val descripcion : String,
    val frecuencia : Int,
    val diasDescanso : Int,
    val dificultad : String,
    val estado : String

    ) {


    constructor() : this(
        0,
        "",
        "",
        0,
        0,
        ""
        ,""
        )
}

