package com.simplefit.ui.features.mainApp.routines

import com.simplefit.models.Rutinas

data class RoutinesUiState(
    val routines : List<Rutinas>

    ) {


    constructor() : this(
        routines = emptyList()
        )
}