package com.simplefit.ui.features.mainApp.verEntrenamiento

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.MaquinasRepository
import com.simplefit.ui.features.mainApp.MaquinaUiState
import com.simplefit.ui.features.mainApp.rutinas.RutinasUiState
import com.simplefit.ui.features.toMaquinaUiState
import com.simplefit.ui.features.toVerEntrenamientoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class VerEntrenamientoViewModel @Inject constructor(
    private val maquinasRepository : MaquinasRepository,
) : ViewModel() {
    var userid by mutableStateOf("")
        private set
    var verRutinaUiState by mutableStateOf(VerEntrenamientoUiState())
        private set
    var dia by mutableStateOf(obtenerDiaDeLaSemana())

    var mostrarDialog by mutableStateOf(false)

    val onMostrarDialog: (Boolean) -> Unit by mutableStateOf({
        mostrarDialog = it
    })
    var maquinaUiState by mutableStateOf(MaquinaUiState())
    fun setRutina(rutina : RutinasUiState)
    {
        viewModelScope.launch {
            userid = rutina.userid
            var rutina2 = rutina.toVerEntrenamientoUiState()
            rutina2 = rutina2.copy(ejercicio = maquinasRepository.get(rutina.rutinaid,dia).map { it.toMaquinaUiState() })
            verRutinaUiState = rutina2
        }
    }
    fun onVerRoutinesEvent(verEntrenamientoEvent: VerEntrenamientoEvent) {
        when (verEntrenamientoEvent) {
            is VerEntrenamientoEvent.onClickEjercicio -> {

                maquinaUiState = verEntrenamientoEvent.ejercicio
                mostrarDialog = true
            }


            else -> {}
        }

    }
    fun obtenerDiaDeLaSemana(): String {
        val dias = arrayOf("D", "L", "M", "X", "J", "V", "S")
        val calendario = Calendar.getInstance()
        val diaDeLaSemana = calendario.get(Calendar.DAY_OF_WEEK)
        return dias[diaDeLaSemana - 1]
    }
}
