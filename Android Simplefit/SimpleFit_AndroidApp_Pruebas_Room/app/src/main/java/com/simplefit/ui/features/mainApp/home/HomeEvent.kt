package com.simplefit.ui.features.mainApp.home

import androidx.compose.ui.graphics.ImageBitmap
import com.simplefit.ui.features.mainApp.rutinas.RutinasUiState

sealed interface HomeEvent {
    data class OnCambiarfoto(val image: ImageBitmap) : HomeEvent

    data class onVerEntrenamientoClicked(val onNavigateToVerEntrenamiento: ((RutinasUiState) -> Unit)?) : HomeEvent

}