package com.simplefit.ui.features.mainApp.verRutina

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.MaquinasRepository
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.models.Rutinas
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.toVerRutinaUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerRutinaViewModel @Inject constructor(
    //private val usuarioRepository: UsuarioRepository,
    //private val rutinasRepository: RutinasRepository,
    private val maquinasRepository : MaquinasRepository,
) : ViewModel() {
    var verRutinaUiState by mutableStateOf(VerRutinaUiState())
        private set
    fun setRutina(rutina : RoutinesUiState)
    {
        viewModelScope.launch {
            verRutinaUiState = rutina.toVerRutinaUiState()
        }
    }
    fun onVerRoutinesEvent(verRoutinesEvent: VerRutinaEvent) {
        when (verRoutinesEvent) {
            is VerRutinaEvent.onVolverAtras -> {

            }
            is VerRutinaEvent.onCambiarDia -> {
                viewModelScope.launch {
                    verRutinaUiState.ejercicio =  maquinasRepository.get(verRutinaUiState.rutinaid, verRoutinesEvent.dia)
                }

            }

            else -> {}
        }

    }
}
