package com.simplefit.ui.features.mainApp

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class MainAppUiState(

    val email: String,
    val dni : String,
    val password: String,
    val nombre : String,
    val altura : String,
    val peso : String,
    val edad : String,
    val sexo : String,
    val somatotipo : String,
    val alergia : String?
){
    constructor() : this(
    email = "",
    dni = "",
    password = "",
    nombre = "",
    altura = "",
    peso = "",
    edad = "",
    sexo = "",
    somatotipo = "",
    alergia = null
    )
}
