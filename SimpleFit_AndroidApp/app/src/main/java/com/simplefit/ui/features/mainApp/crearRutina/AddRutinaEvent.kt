package com.simplefit.ui.features.mainApp.crearRutina

import com.simplefit.ui.features.mainApp.routines.RoutinesEvent
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState

sealed interface AddRutinaEvent {
    data class onVolverAtras (val onNavigateToRutinas:(()->Unit)?) : AddRutinaEvent
    //data class onVerClicked(val onNavigateToVerRutina:((rutinaid:RoutinesUiState)->Unit)?) : AddRutinaEvent

    data class onVerClicked(val onNavigateToVerRutina: ((RoutinesUiState) -> Unit)? = null) : AddRutinaEvent
    data object onTodasClicked : AddRutinaEvent

    data object onUnSelectClicked : AddRutinaEvent
    data object onOrdenarPorDescanso : AddRutinaEvent
    data object onOrdenarPorFrecuencia : AddRutinaEvent
    data object onOrdenarPorDificultad : AddRutinaEvent
    data object onFiltroClicked : AddRutinaEvent
    data class onRutinaClicked(val rutinaid: Int) : AddRutinaEvent
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