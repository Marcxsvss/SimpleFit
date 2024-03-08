package com.simplefit.ui.features.mainApp.home


data class HomeUiState(
    val email : String,

) {


    constructor() : this(
        email = "",

    )
}