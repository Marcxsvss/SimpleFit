package com.simplefit.ui.features.mainApp.routines

import com.simplefit.ui.features.userAuthentication.login.LoginEvent

sealed interface RoutinesEvent {
    data class onRutinaClicked(val rutinaid: Int) : RoutinesEvent
    data class onVerClicked(val onNavigateToVerRutina:((rutinaid:RoutinesUiState)->Unit)?) : RoutinesEvent

    data object onAddClicked : RoutinesEvent

    data class onDeleteClicked(val rutinaid: Int) : RoutinesEvent

    data class onCompartirClicked(val nombre: String) : RoutinesEvent

    data class  OnClickCrearRutina(val onNavigateProfile: () -> Unit): RoutinesEvent

}