package com.simplefit.ui.features.mainApp.routines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.simplefit.data.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RoutinesViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository,
    private val rutinasRepository : RutinasRepository
) : ViewModel() {
    var routinesUiState by mutableStateOf(RoutinesUiState())
        private set
    var routinesList by mutableStateOf(listOf<RoutinesUiState>())
        private set

    fun setRoutinesList(routinesList: List<RoutinesUiState>) {
        this.routinesList = routinesList
    }
    fun onRoutinesEvent(routinesEvent: RoutinesEvent) {
        when (routinesEvent) {
            is RoutinesEvent.onRutinaClicked -> {

            }
            is RoutinesEvent.onAddClicked -> {

            }
            is RoutinesEvent.onVerClicked -> {

            }
            is RoutinesEvent.onCompartirClicked -> {

            }
            is RoutinesEvent.onDeleteClicked -> {

            }
            is RoutinesEvent.OnClickCrearRutina -> {

            }
            else -> {}
        }
    }
}