package com.simplefit.ui.features.mainApp.routines

data class RoutinesUiState(
    val email : String,

    ) {


    constructor() : this(
        email = "",
    )
}