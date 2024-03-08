package com.simplefit.ui.features.mainApp.profile

data class ProfileUiState(
    val email : String,

    ) {


    constructor() : this(
        email = "",
        )
}