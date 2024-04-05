package com.simplefit.models

data class Usuario(
    val email: String,
    val password: String,
    val dni: String,
    val nombre : String,
    val altura : String,
    val peso : String,
    val edad : String,
    val sexo : String,
    val somatotipo : String,
    val intolerancia : String?

)
