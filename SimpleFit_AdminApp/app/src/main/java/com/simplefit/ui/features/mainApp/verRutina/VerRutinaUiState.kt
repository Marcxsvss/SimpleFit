package com.simplefit.ui.features.mainApp.verRutina

import com.simplefit.ui.features.mainApp.MaquinaUiState

data class VerRutinaUiState(
    val rutinaid: Int,
    val titulo : String,
    val descripcion : String,
    var ejercicio : List<MaquinaUiState>,
    val frecuencia : Int,
    val estado : String = "Added"

    ) {


    constructor() : this(
        0,
        "",
        "Descanso",
        ejercicio = listOf(),
        0,

    )
}

