package com.simplefit.ui.features.mainApp

import androidx.compose.ui.graphics.ImageBitmap

data class MaquinaUiState(
    val maquinaid : Int,
    val nombre : String,
    val musculo : String,
    val imagen : ImageBitmap?,
    val descripcion : String

) {


    constructor() : this(
        0,
        "",
        "",
        null,
        ""
    )

}