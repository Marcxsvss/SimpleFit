package com.simplefit.ui.features.mainApp.routines

import com.simplefit.models.Rutinas

data class RoutinesUiState(
    val id: Int,
    val titulo : String,
    val descripcion : String,
    val objetivo : String,
    val frecuencia : String,

    ) {


    constructor() : this(
        0,
        "",
        "",
        "",
        "",
        )
}