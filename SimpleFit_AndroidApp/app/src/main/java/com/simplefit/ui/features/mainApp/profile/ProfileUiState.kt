package com.simplefit.ui.features.mainApp.profile

data class ProfileUiState(
    val email : String,
    val edad: String,
    val altura : String,
    val peso : String,
    val sexo : String,
    val somatotipo : String,
    val alergia : String,
    val estaRegistrado : Boolean
) {



    constructor() : this(
        email = "",
        edad = "",
        altura="",
        peso = "",
        sexo="",
        somatotipo="",
        alergia="",
        estaRegistrado = false
    )
}