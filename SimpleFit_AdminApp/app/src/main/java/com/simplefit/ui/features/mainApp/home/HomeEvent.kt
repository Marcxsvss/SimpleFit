package com.simplefit.ui.features.mainApp.home

import com.simplefit.ui.features.mainApp.crearRutina.AddRutinaEvent
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState

sealed interface HomeEvent {
    data class OnClickConsejos(val dia : String) : HomeEvent
    data class OnClickCompartir(val dia : String) : HomeEvent
    data class onNavigateToScreen(val index : Int) : HomeEvent
    data class onVerEntrenamientoClicked(val onNavigateToVerEntrenamiento: ((RoutinesUiState) -> Unit)) : HomeEvent
}