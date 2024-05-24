package com.simplefit.ui.features.mainApp.home

import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face2
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector


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
