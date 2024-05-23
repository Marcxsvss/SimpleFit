package com.simplefit.ui.features.mainApp.verRutina

import com.simplefit.ui.features.mainApp.MaquinaUiState

sealed interface VerRutinaEvent {
    data class onVolverAtras(val rutinaid: Int) : VerRutinaEvent
    data class onCambiarDia(val dia: String) : VerRutinaEvent
    data class onClickEjercicio(val ejercicio: MaquinaUiState) : VerRutinaEvent
    data class onAddRutina(val onNavigateToAddRutina:((userid:String)->Unit)?) : VerRutinaEvent
    data class onActivarClicked(val onNavigateToRutinas:((userid:String)->Unit)?) : VerRutinaEvent
    data class onDesactivarClicked(val onNavigateToRutinas:((userid:String)->Unit)?) : VerRutinaEvent

}