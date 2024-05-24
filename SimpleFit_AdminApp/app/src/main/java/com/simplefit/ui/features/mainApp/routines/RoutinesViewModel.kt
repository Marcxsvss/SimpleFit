package com.simplefit.ui.features.mainApp.routines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.RutinaMaquinaRepository
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.data.UsuarioRutinaRepository
import com.simplefit.ui.features.mainApp.users.UsersEvent
import com.simplefit.ui.features.mainApp.users.UsersUiState
import com.simplefit.ui.features.toRutinasUiState
import com.simplefit.ui.features.toUsuarioUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class RoutinesViewModel @Inject constructor(
    private val rutinasRepository: RutinasRepository,

) : ViewModel() {
    var routinesUiState by mutableStateOf(RoutinesUiState())
        private set
    var routinesList by mutableStateOf(listOf<RoutinesUiState>())
        private set
    var busquedaState by mutableStateOf("")
    var mostrarDialog by mutableStateOf(false)

    val onMostrarDialog: (Boolean) -> Unit by mutableStateOf({
        mostrarDialog = it
    })
    fun setRoutines() {
        viewModelScope.launch {
            routinesList = rutinasRepository.get().map { it.toRutinasUiState() }
            routinesUiState = RoutinesUiState()
        }

    }

    fun onRoutinesEvent(routinesEvent: RoutinesEvent) {
        when (routinesEvent) {
            is RoutinesEvent.onRutinaClicked -> {
                routinesUiState = routinesList.find { it.rutinaid == routinesEvent.rutinaid }!!
            }

            is RoutinesEvent.onVerClicked -> {
                routinesEvent.onNavigateToVerRutina?.let { it(routinesUiState) }
            }

            is RoutinesEvent.onDeleteClicked -> {//Solucionar este delete, tiene que borrar solo los registros que asocian la rutina al usuario, es decir, la tabla UsuarioRutina
                viewModelScope.launch {
                    rutinasRepository.delete(routinesUiState.rutinaid)
                    routinesList = rutinasRepository.get().map { it.toRutinasUiState() }
                    routinesUiState = RoutinesUiState()
                }
            }

            is RoutinesEvent.onCancelClicked -> {
                routinesUiState = RoutinesUiState()
            }

            is RoutinesEvent.onSearchChanged -> {
                busquedaState = routinesEvent.texto
                viewModelScope.launch {
                    routinesList = rutinasRepository.get().map { it.toRutinasUiState() }.filter {
                        it.dificultad.lowercase(Locale.ROOT).contains(routinesEvent.texto) ||
                                it.rutinaid.toString().contains(routinesEvent.texto) ||
                                it.titulo.lowercase(Locale.ROOT).contains(routinesEvent.texto)
                    }
                }
            }

            else -> {}
        }

    }
}
