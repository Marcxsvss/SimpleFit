package com.simplefit.models

import android.net.Uri

data class Usuario(
    val email: String,
    val password: String,
    val nombre : String,
    val altura : String,
    val peso : String,
    val edad : String,
    val sexo : String,
    val somatotipo : String,
    val rutinaState : Int?,
    val cargo : Int,
    val foto : String?

){
    constructor() : this(
        email = "",
        password = "",
        nombre = "",
        altura = "",
        peso = "",
        edad = "",
        sexo = "",
        somatotipo = "",
        rutinaState = 0,
        cargo = 0,
        foto = null
    )
}
