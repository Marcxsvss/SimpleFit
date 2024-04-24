package com.simplefit.ui.features.mainApp.crearRutina

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRutinaViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository,
    private val rutinasRepository: RutinasRepository
) : ViewModel() {
    var addRutinaUiState by mutableStateOf(AddRutinaUiState())
        private set
    fun setRutinas(userid : String)
    {
        viewModelScope.launch {
            addRutinaUiState = addRutinaUiState.copy(rutinas = rutinasRepository.get(userid))
        }
    }
    fun onAddRutinaEvent(addRutinaEvent: AddRutinaEvent) {
        when (addRutinaEvent) {
            is AddRutinaEvent.onVolverAtras -> {

            }
            is AddRutinaEvent.onTodasClicked -> {

            }
            is AddRutinaEvent.onRecomendadasClicked -> {

            }

            else -> {}
        }

    }
}