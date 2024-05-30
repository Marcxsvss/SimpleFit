package com.simplefit.ui.features.mainApp.rutinas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.data.UsuarioRutinaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RutinasViewModel @Inject constructor(
    private val rutinasRepository : RutinasRepository,
    private val usuarioRutinaRepository: UsuarioRutinaRepository,
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var routinesUiState by mutableStateOf(RutinasUiState())
        private set
    var routinesList by mutableStateOf(listOf<RutinasUiState>())
        private set
    var userid by mutableStateOf("")
    private set
    var mostrarSnackBar by mutableStateOf(false)
    val onMostrarSnackBar: () -> Unit by mutableStateOf({
        mostrarSnackBar = !mostrarSnackBar
    })

    fun setRoutines(userid : String) {
        this.userid = userid
        viewModelScope.launch {
            routinesList = rutinasRepository.get(userid)
            routinesUiState = RutinasUiState()
        }

    }
    fun onRoutinesEvent(routinesEvent: RutinasEvent) {
        when (routinesEvent) {
            is RutinasEvent.onRutinaClicked -> {
                routinesUiState = routinesList.find { it.rutinaid == routinesEvent.rutinaid }!!
            }
            is RutinasEvent.onAddClicked -> {
                routinesEvent.onNavigateToAddRutina?.let { it(userid) }
            }
            is RutinasEvent.onVerClicked -> {
                routinesEvent.onNavigateToVerRutina?.let { it(routinesUiState) }
            }
            is RutinasEvent.onDeleteClicked -> {
                viewModelScope.launch {
                    if(usuarioRepository.get(userid)?.rutinaState == routinesUiState.rutinaid)
                        onMostrarSnackBar()
                    else
                    {
                        usuarioRutinaRepository.delete(routinesUiState.userid, routinesUiState.rutinaid)
                        routinesList = rutinasRepository.get(userid)
                        routinesUiState = RutinasUiState()
                    }

                }
            }
            is RutinasEvent.onCancelClicked -> {
                routinesUiState = RutinasUiState()
            }

            else -> {}
        }
    }
}