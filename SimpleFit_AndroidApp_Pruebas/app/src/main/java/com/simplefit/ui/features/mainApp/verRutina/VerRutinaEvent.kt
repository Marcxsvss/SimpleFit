package com.simplefit.ui.features.mainApp.verRutina

sealed interface VerRutinaEvent {
    data class onVolverAtras(val rutinaid: Int) : VerRutinaEvent
//    data object onAddClicked : VerRutinasEvent
//
//    data class onVerClicked(val rutinaid: Int) : VerRutinasEvent
//
//    data class onDeleteClicked(val rutinaid: Int) : VerRutinasEvent
//
//    data class onCompartirClicked(val nombre: String) : VerRutinasEvent
//
//    data class  OnClickCrearRutina(val onNavigateProfile: () -> Unit): VerRutinasEvent

}