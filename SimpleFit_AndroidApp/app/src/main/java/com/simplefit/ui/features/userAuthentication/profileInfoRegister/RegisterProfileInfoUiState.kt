package com.simplefit.ui.features.userAuthentication.profileInfoRegister

import com.simplefit.models.Usuario

data class RegisterProfileInfoUiState(
    val email : String,
    val edad: Int,
    val altura : Int,
    val peso : Int,
    val sexo : String,
    val somatotipo : String,
    val alergia : String,
    val estaRegistrado : Boolean
) {



    constructor() : this(
        email = "",
        edad = 0,
        altura=0,
        peso = 0,
        sexo="",
        somatotipo="",
        alergia="",
        estaRegistrado = false
    )
}