package com.simplefit.ui.features.profileInfoRegister

import com.simplefit.models.Usuario

data class RegisterProfileInfoUiState(
    val email: String,
    val password: String,
    val dni : String,
    //val estaRegistrado : Boolean
) {


    constructor() : this(
        email = "",
        password = "",
        dni="",
        //estaRegistrado = false
    )
}