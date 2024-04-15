package com.simplefit.ui.features.mainApp.routines

import com.simplefit.models.Rutinas

data class RoutinesUiState(
    val rutinaid: Int,
    val userid : String,
    val titulo : String,
    val descripcion : String,
    val objetivo : String,
    val frecuencia : Int,

    ) {


    constructor() : this(
        0,
        "",
        "",
        "",
        "",
        0,
        )
}

