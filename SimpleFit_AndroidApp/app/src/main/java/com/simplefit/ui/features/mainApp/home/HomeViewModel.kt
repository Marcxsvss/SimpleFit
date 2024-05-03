package com.simplefit.ui.features.mainApp.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.ui.features.mainApp.crearRutina.AddRutinaEvent
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.toRutinasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository,
    private val rutinasRepository: RutinasRepository,
) : ViewModel() {
    var homeUiState by mutableStateOf(HomeUiState())
        private set
    var rutinaUiState by mutableStateOf(RoutinesUiState())
        private set

    //var indexState by mutableStateOf(0)
    fun setUsuario(email : String)
    {
        viewModelScope.launch {
            val usuario = usuarioRepository.get(email)
            if (usuario != null) {
                homeUiState = homeUiState.copy(
                    email = usuario.email,
                    nombre = usuario.nombre
                )
            }
            rutinaUiState = rutinasRepository.getRutina(usuario?.rutinaState).toRutinasUiState()
        }
    }
    fun onHomeEvent(homeEvent: HomeEvent) {
        when (homeEvent) {

            is HomeEvent.onVerEntrenamientoClicked -> {
                homeEvent.onNavigateToVerEntrenamiento?.let { it(rutinaUiState) }

            }

            else -> {}
        }
    }
}