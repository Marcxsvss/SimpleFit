package com.simplefit.ui.features.mainApp.verRutina

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.MaquinasRepository
import com.simplefit.ui.features.mainApp.MaquinaUiState
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.toMaquinaUiState
import com.simplefit.ui.features.toVerRutinaUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerRutinaViewModel @Inject constructor(
    private val maquinasRepository : MaquinasRepository,
) : ViewModel() {
    var verRutinaUiState by mutableStateOf(VerRutinaUiState())
        private set
    var diaSeleccionado by mutableStateOf("L")

    var mostrarDialog by mutableStateOf(false)

    val onMostrarDialog: (Boolean) -> Unit by mutableStateOf({
        mostrarDialog = it
    })
    var maquinaUiState by mutableStateOf(MaquinaUiState())
    fun setRutina(rutina : RoutinesUiState)
    {
        viewModelScope.launch {
            var rutina2 = rutina.toVerRutinaUiState()
            rutina2 = rutina2.copy(ejercicio = maquinasRepository.get(rutina.rutinaid,diaSeleccionado).map { it.toMaquinaUiState() })
            verRutinaUiState = rutina2
        }
    }
    fun onVerRoutinesEvent(verRoutinesEvent: VerRutinaEvent) {
        when (verRoutinesEvent) {
            is VerRutinaEvent.onVolverAtras -> {

            }
            is VerRutinaEvent.onCambiarDia -> {
                viewModelScope.launch {
                    diaSeleccionado = verRoutinesEvent.dia
                    verRutinaUiState =  verRutinaUiState.copy(ejercicio = maquinasRepository.get(verRutinaUiState.rutinaid, verRoutinesEvent.dia).map { it.toMaquinaUiState() })
                }
            }
            is VerRutinaEvent.onClickEjercicio -> {

                maquinaUiState = verRoutinesEvent.ejercicio
                mostrarDialog = true
            }



            else -> {}
        }

    }
}
