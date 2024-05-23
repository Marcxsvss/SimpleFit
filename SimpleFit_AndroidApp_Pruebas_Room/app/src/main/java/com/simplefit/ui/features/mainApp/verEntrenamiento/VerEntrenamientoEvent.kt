package com.simplefit.ui.features.mainApp.verEntrenamiento

import com.simplefit.ui.features.mainApp.MaquinaUiState

sealed interface VerEntrenamientoEvent {
    data class onVolverAtras(val rutinaid: Int) : VerEntrenamientoEvent
    data class onClickEjercicio(val ejercicio: MaquinaUiState) : VerEntrenamientoEvent

}