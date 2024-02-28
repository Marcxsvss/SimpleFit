package com.simplefit.ui.features.accountInfoRegister

data class RegisterAccountInfoUiState(
    val email: String,
    val password: String,
    val dni : String,
    val estaRegistrado : Boolean
) {
    constructor() : this(
        email = "",
        password = "",
        dni="",
        estaRegistrado = false
    )
}