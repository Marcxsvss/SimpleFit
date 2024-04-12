package com.simplefit.ui.features.mainApp.routines

sealed interface RoutinesEvent {
    data class onRutinaClicked(val id: Int) : RoutinesEvent
    data object onAddClicked : RoutinesEvent

    data class onVerClicked(val id: Int) : RoutinesEvent

    data class onDeleteClicked(val id: Int) : RoutinesEvent

    data class onCompartirClicked(val nombre: String) : RoutinesEvent

    data class  OnClickCrearRutina(val onNavigateProfile: () -> Unit): RoutinesEvent

}