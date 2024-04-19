package com.simplefit.ui.features.mainApp.verRutina

data class VerRutinaUiState(
    val rutinaid: Int,
    val userid : String,
    val titulo : String,
    val descripcion : String,
    val objetivo : String,
    val frecuencia : Int,
    ) {


    constructor() : this(
        0,
        "",
        "",
        "",
        "",
        0)
}

