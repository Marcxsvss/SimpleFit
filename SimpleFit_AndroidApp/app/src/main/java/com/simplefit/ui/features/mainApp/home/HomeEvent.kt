package com.simplefit.ui.features.mainApp.home

sealed interface HomeEvent {
    data class OnClickVerEntrenamiento(val dia : String) : HomeEvent
    data class OnClickConsejos(val dia : String) : HomeEvent
    data class OnClickCompartir(val dia : String) : HomeEvent
    data class onNavigateToScreen(val index : Int) : HomeEvent
}