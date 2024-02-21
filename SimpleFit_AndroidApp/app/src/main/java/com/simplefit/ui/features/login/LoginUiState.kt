package com.simplefit.ui.features.login

data class LoginUiState(
    val email: String,
    val password: String,
    val estaLogeado: Boolean
) {
    constructor() : this(
        email = "",
        password = "",
        estaLogeado=false
    )
}