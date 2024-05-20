package com.simplefit.ui.features.mainApp.users

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersUiState(
    val email: String,
    val password: String,
    val nombre: String,
    val altura: String,
    val peso: String,
    val edad: String,
    val sexo: String,
    val somatotipo: String,
    val rutinaState: Int?,
    val acceso: Int

) : Parcelable {


    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        0,
        0

    )
}

