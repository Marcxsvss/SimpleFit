package com.simplefit.ui.features.mainApp.home

import androidx.compose.ui.graphics.ImageBitmap
import com.simplefit.ui.features.mainApp.crearRutina.AddRutinaEvent
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState

sealed interface HomeEvent {
    data class OnCambiarfoto(val image: ImageBitmap) : HomeEvent

    //data class OnClickCompartir(val dia : String) : HomeEvent
    data class onVerEntrenamientoClicked(val onNavigateToVerEntrenamiento: ((RoutinesUiState) -> Unit)?) : HomeEvent

}