package com.simplefit.ui.features.mainApp.crearRutina

import com.simplefit.models.Rutinas
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState

data class AddRutinaUiState(
    val rutinas : List<RoutinesUiState>,

    ) {


    constructor() : this(
        listOf()
    )
}

