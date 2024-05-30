package com.simplefit.ui.features.mainApp.rutinas

sealed interface RutinasEvent {
    data class onRutinaClicked(val rutinaid: Int) : RutinasEvent
    data class onVerClicked(val onNavigateToVerRutina: ((rutinaid: RutinasUiState) -> Unit)?) : RutinasEvent

    data class onAddClicked(val onNavigateToAddRutina: ((userid: String) -> Unit)?) : RutinasEvent

    data object onDeleteClicked : RutinasEvent
    data object onCancelClicked : RutinasEvent


}