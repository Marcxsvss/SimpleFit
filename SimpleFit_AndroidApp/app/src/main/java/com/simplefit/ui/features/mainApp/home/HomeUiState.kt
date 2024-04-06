package com.simplefit.ui.features.mainApp.home


data class HomeUiState(
    val email : String,
    val nombre : String
) {


    constructor() : this(
        email = "",
        nombre = ""

    )
}