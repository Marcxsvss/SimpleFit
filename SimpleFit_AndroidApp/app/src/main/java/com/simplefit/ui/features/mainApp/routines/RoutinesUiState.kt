package com.simplefit.ui.features.mainApp.routines

data class RoutinesUiState(
    routines : List<Routine>

    ) {


    constructor() : this(
        email = "",
    )
}