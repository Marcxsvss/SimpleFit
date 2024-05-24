package com.simplefit.ui.features.mainApp.routines

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoutinesUiState(
    val rutinaid: Int,
    val titulo : String,
    val descripcion : String,
    val frecuencia : Int,
    val diasDescanso : Int,
    val dificultad : String,

    ) : Parcelable {


    constructor() : this(
        0,
        "",
        "",
        0,
        0,
        "",
        )
}

