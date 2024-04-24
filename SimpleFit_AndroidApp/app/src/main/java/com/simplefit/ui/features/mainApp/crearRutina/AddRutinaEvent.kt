package com.simplefit.ui.features.mainApp.crearRutina

sealed interface AddRutinaEvent {
    data class onVolverAtras(val rutinaid: Int) : AddRutinaEvent
    data object onTodasClicked : AddRutinaEvent
    data object onRecomendadasClicked : AddRutinaEvent
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