package com.simplefit.ui.features.mainApp.verRutina

import com.simplefit.models.Maquina

data class VerRutinaUiState(
    val rutinaid: Int,
    val titulo : String,
    val descripcion : String,
    var ejercicio : List<MaquinaUiState>,
    val frecuencia : Int

    ) {


    constructor() : this(
        0,
        "",
        "Descanso",
        ejercicio = listOf(),
        0,

    )
}

