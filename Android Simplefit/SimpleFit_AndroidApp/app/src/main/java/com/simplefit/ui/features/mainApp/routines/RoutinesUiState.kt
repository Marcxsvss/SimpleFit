package com.simplefit.ui.features.mainApp.routines

import android.os.Parcelable
import com.simplefit.models.Rutinas
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoutinesUiState(
    val rutinaid: Int,
    val titulo : String,
    val descripcion : String,
    val frecuencia : Int,
    val diasDescanso : Int,
    val dificultad : String,
    val estado : String,
    val userid : String

    ) : Parcelable {


    constructor() : this(
        0,
        "",
        "",
        0,
        0,
        "",
        "",
        ""
        )
}
