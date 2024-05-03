package com.simplefit.ui.features.mainApp.crearRutina

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.toRutinasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRutinaViewModel @Inject constructor(
    private val rutinasRepository: RutinasRepository
) : ViewModel() {
    var rutinaUiState by mutableStateOf(RoutinesUiState())
        private set
    var rutinasState by mutableStateOf(listOf<RoutinesUiState>())
        private set
    var userid by mutableStateOf("")
    private set
    fun setRutinas(userid : String)
    {
        this.userid = userid
        viewModelScope.launch {
            rutinasState = rutinasRepository.get().map { it.toRutinasUiState("UnAdded",userid)}
        }
    }
    var mostrarDialog by mutableStateOf(false)

    val onMostrarDialog: (Boolean) -> Unit by mutableStateOf({
        mostrarDialog = it
    })
    fun onAddRutinaEvent(addRutinaEvent: AddRutinaEvent) {
        when (addRutinaEvent) {
            is AddRutinaEvent.onVolverAtras -> {
                addRutinaEvent.onNavigateToRutinas
            }
            is AddRutinaEvent.onTodasClicked -> {
                viewModelScope.launch {
                    rutinasState = rutinasRepository.get().map { it.toRutinasUiState("UnAdded",userid) }
                }
            }
            is AddRutinaEvent.onFiltroClicked -> {
                viewModelScope.launch {
                    mostrarDialog = true
                }
            }
            is AddRutinaEvent.onUnSelectClicked -> {
                rutinaUiState = RoutinesUiState()
            }
            is AddRutinaEvent.onOrdenarPorFrecuencia -> {
                viewModelScope.launch { rutinasState = rutinasRepository.get().map { it.toRutinasUiState("UnAdded",userid) }.sortedBy { it.frecuencia } }
            }
            is AddRutinaEvent.onOrdenarPorDificultad -> {
                viewModelScope.launch { rutinasState = rutinasRepository.get().map { it.toRutinasUiState("UnAdded",userid) }.sortedBy { it.dificultad } }
            }
            is AddRutinaEvent.onOrdenarPorDescanso -> {
                viewModelScope.launch { rutinasState = rutinasRepository.get().map { it.toRutinasUiState("UnAdded",userid) }.sortedBy { it.diasDescanso } }
            }
            is AddRutinaEvent.onRutinaClicked -> {
                rutinaUiState = rutinasState.find { it.rutinaid == addRutinaEvent.rutinaid }!!
            }
            is AddRutinaEvent.onVerClicked -> {
                addRutinaEvent.onNavigateToVerRutina?.let { it(rutinaUiState) }

            }

            else -> {}
        }

    }
}