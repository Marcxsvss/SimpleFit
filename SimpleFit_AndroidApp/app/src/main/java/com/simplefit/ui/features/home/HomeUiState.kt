package com.simplefit.ui.features.home


data class HomeUiState(
    val email : String,

) {


    constructor() : this(
        email = "",

    )
}