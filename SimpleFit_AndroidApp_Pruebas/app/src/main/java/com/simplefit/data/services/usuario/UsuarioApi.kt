package com.simplefit.data.services.usuario

import com.google.gson.annotations.SerializedName

data class UsuarioApi(
    val email: String,
    val contraseña: String,
    val dni: String,
    val nombre : String,
    val altura : String,
    val peso : String,
    val edad : String,
    val sexo : String,
    val somatotipo : String,
    val intolerancia : String?
)
