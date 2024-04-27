package com.simplefit.ui.features.mainApp.routines

import com.simplefit.ui.features.userAuthentication.login.LoginEvent

sealed interface RoutinesEvent {
    data class onRutinaClicked(val rutinaid: Int) : RoutinesEvent
    data class onVerClicked(val onNavigateToVerRutina:((rutinaid:RoutinesUiState)->Unit)?) : RoutinesEvent

    data class onAddClicked(val onNavigateToAddRutina:((userid:String)->Unit)?) : RoutinesEvent

    data class onDeleteClicked(val rutinaid: Int) : RoutinesEvent

    data class  OnClickCrearRutina(val onNavigateProfile: () -> Unit): RoutinesEvent

}