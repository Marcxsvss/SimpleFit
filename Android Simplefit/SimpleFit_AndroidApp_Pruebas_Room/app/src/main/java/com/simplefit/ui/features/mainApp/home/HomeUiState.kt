package com.simplefit.ui.features.mainApp.home


import androidx.compose.ui.graphics.ImageBitmap


data class HomeUiState(
    val email : String,
    val nombre : String,
    val foto : ImageBitmap?,
) {


    constructor() : this(
        email = "",
        nombre = "",
        foto = null

    )
}
