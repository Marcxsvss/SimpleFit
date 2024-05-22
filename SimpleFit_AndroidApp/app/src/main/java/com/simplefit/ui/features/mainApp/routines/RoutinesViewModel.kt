package com.simplefit.ui.features.mainApp.routines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.data.UsuarioRutinaRepository
import com.simplefit.data.toRutinasEntity
import com.simplefit.ui.features.toRutinasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RoutinesViewModel @Inject constructor(
    private val rutinasRepository : RutinasRepository,
    private val usuarioRutinaRepository: UsuarioRutinaRepository,
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var routinesUiState by mutableStateOf(RoutinesUiState())
        private set
    var routinesList by mutableStateOf(listOf<RoutinesUiState>())
        private set
    var userid by mutableStateOf("")
    private set


    fun setRoutines(userid : String) {
        this.userid = userid
        viewModelScope.launch {
            routinesList = rutinasRepository.get(userid)
            routinesUiState = RoutinesUiState()//igual hay que quitarlo
        }

    }
    fun onRoutinesEvent(routinesEvent: RoutinesEvent) {
        when (routinesEvent) {
            is RoutinesEvent.onRutinaClicked -> {
                routinesUiState = routinesList.find { it.rutinaid == routinesEvent.rutinaid }!!
            }
            is RoutinesEvent.onAddClicked -> {
                routinesEvent.onNavigateToAddRutina?.let { it(userid) }
            }
            is RoutinesEvent.onVerClicked -> {
                routinesEvent.onNavigateToVerRutina?.let { it(routinesUiState) }
            }
            is RoutinesEvent.onDeleteClicked -> {
                viewModelScope.launch {
                    usuarioRutinaRepository.delete(routinesUiState.userid, routinesUiState.rutinaid)
                    routinesList = rutinasRepository.get(userid)
                    if(usuarioRepository.get(userid)?.rutinaState == routinesUiState.rutinaid)
                        usuarioRepository.updateRutinaState(userid, 0) //Corregir que al borrar la rutina activa no se actualiza entrenamiento.
                    routinesUiState = RoutinesUiState()
                }
            }
            is RoutinesEvent.onCancelClicked -> {
                routinesUiState = RoutinesUiState()
            }

            else -> {}
        }
    }
}