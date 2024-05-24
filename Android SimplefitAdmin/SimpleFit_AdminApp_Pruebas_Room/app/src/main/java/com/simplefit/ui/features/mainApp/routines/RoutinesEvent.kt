package com.simplefit.ui.features.mainApp.routines



sealed interface RoutinesEvent {
    data class onSearchChanged(val texto: String) : RoutinesEvent
    data object onCancelClicked : RoutinesEvent
    data class onRutinaClicked(val rutinaid: Int) : RoutinesEvent
    data class onVerClicked(val onNavigateToVerRutina:((rutinaid:RoutinesUiState)->Unit)?) : RoutinesEvent
    data object onDeleteClicked : RoutinesEvent

}