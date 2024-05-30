package com.simplefit.ui.features.mainApp.addRutina

import com.simplefit.ui.features.mainApp.rutinas.RutinasUiState

sealed interface AddRutinaEvent {
    data class onVolverAtras (val onNavigateToRutinas:(()->Unit)?) : AddRutinaEvent

    data class onVerClicked(val onNavigateToVerRutina: ((RutinasUiState) -> Unit)? = null) : AddRutinaEvent
    data object onTodasClicked : AddRutinaEvent

    data object onUnSelectClicked : AddRutinaEvent
    data object onOrdenarPorDescanso : AddRutinaEvent
    data object onOrdenarPorFrecuencia : AddRutinaEvent
    data object onOrdenarPorDificultad : AddRutinaEvent
    data object onFiltroClicked : AddRutinaEvent
    data class onRutinaClicked(val rutinaid: Int) : AddRutinaEvent


}