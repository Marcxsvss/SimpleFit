package com.simplefit.ui.features.mainApp.verRutina

sealed interface VerRutinaEvent {
    data class onVolverAtras(val rutinaid: Int) : VerRutinaEvent
    data class onCambiarDia(val dia: String) : VerRutinaEvent
}