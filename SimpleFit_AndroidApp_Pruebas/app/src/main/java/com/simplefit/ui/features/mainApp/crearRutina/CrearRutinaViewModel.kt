package com.simplefit.ui.features.mainApp.crearRutina

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CrearRutinaViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository,
    private val rutinasRepository: RutinasRepository
) : ViewModel() {
    var crearRutinaUiState by mutableStateOf(CrearRutinaUiState())
        private set

    fun onCrearRutinaEvent(crearRutinaEvent: CrearRutinaEvent) {
        when (crearRutinaEvent) {
            is CrearRutinaEvent.onVolverAtras -> {

            }
        }

    }
}