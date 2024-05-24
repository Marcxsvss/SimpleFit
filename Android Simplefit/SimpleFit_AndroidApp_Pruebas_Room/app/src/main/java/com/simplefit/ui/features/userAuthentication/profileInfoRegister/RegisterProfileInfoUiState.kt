package com.simplefit.ui.features.userAuthentication.profileInfoRegister

import com.simplefit.models.Usuario

data class RegisterProfileInfoUiState(
    val email : String,
    val edad: String,
    val altura : String,
    val peso : String,
    val sexo : String,
    val somatotipo : String,
    val alergia : String,
) {



    constructor() : this(
        email = "",
        edad = "",
        altura="",
        peso = "",
        sexo="",
        somatotipo="",
        alergia="",

    )
}