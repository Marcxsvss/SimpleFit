package com.simplefit.ui.features.mainApp.routines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.data.toRutinasEntity
import com.simplefit.ui.features.toRutinasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
    var userid by mutableStateOf("")
    private set


    fun setRoutines(userid : String) {
        this.userid = userid
        viewModelScope.launch {
            routinesList = rutinasRepository.get(userid)
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
            is RoutinesEvent.onCompartirClicked -> {

            }
            is RoutinesEvent.onDeleteClicked -> {
                viewModelScope.launch {
                    rutinasRepository.delete(routinesEvent.rutinaid)
                    routinesList = routinesList.toMutableList().apply {
                        remove(routinesList.find { it.rutinaid == routinesEvent.rutinaid })
                    }
                    routinesUiState = RoutinesUiState()
                }



            }
            is RoutinesEvent.OnClickCrearRutina -> {

            }
            else -> {}
        }
    }
}