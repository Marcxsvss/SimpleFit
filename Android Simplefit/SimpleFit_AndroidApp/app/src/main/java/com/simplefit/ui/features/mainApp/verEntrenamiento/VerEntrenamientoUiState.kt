package com.simplefit.ui.features.mainApp.verEntrenamiento

import com.simplefit.ui.features.mainApp.MaquinaUiState


data class VerEntrenamientoUiState(
    val rutinaid: Int,
    val titulo : String,
    val descripcion : String,
    var ejercicio : List<MaquinaUiState>

    ) {


    constructor() : this(
        0,
        "",
        "Descanso",
        ejercicio = listOf(),

    )
}

