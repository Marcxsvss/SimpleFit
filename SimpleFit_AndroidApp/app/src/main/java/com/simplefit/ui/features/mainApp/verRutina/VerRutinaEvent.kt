package com.simplefit.ui.features.mainApp.verRutina

import com.simplefit.ui.features.mainApp.routines.RoutinesEvent

sealed interface VerRutinaEvent {
    data class onVolverAtras(val rutinaid: Int) : VerRutinaEvent
    data class onCambiarDia(val dia: String) : VerRutinaEvent
    data class onClickEjercicio(val ejercicio: MaquinaUiState) : VerRutinaEvent
    data class onAddRutina(val onNavigateToAddRutina:((userid:String)->Unit)?) : VerRutinaEvent

}