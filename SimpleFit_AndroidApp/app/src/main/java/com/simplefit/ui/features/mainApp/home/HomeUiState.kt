package com.simplefit.ui.features.mainApp.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face2
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector


data class HomeUiState(
    val email : String,
    val nombre : String,
    val foto : ImageBitmap,
) {


    constructor() : this(
        email = "",
        nombre = "",
        foto = ImageBitmap(1,1)

    )
}
