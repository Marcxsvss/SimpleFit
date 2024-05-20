package com.simplefit.data.services.usuario

import com.google.gson.annotations.SerializedName

data class UsuarioApi(
    val email: String,
    val password: String,
    val nombre : String,
    val altura : String,
    val peso : String,
    val edad : String,
    val sexo : String,
    val somatotipo : String,
    val rutinastate : Int?,
    val acceso : Int
)
