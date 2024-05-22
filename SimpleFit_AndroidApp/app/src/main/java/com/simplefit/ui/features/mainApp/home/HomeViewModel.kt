package com.simplefit.ui.features.mainApp.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.ConsejosRepository
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.ui.features.mainApp.crearRutina.AddRutinaEvent
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.toRutinasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository,
    private val rutinasRepository: RutinasRepository,
    private val ConsejosRepository: ConsejosRepository
) : ViewModel() {
    var homeUiState by mutableStateOf(HomeUiState())
        private set
    var rutinaUiState : RoutinesUiState? by mutableStateOf(null)
        private set
    var consejos : List<String> = listOf()

    fun onChangePhoto(ImageBitmap: ImageBitmap) {
        homeUiState = homeUiState.copy(
            foto = ImageBitmap
        )
    }
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
            consejos = ConsejosRepository.get()
        }
    }
    fun onHomeEvent(homeEvent: HomeEvent) {
        when (homeEvent) {
            is HomeEvent.onVerEntrenamientoClicked -> {
                if(rutinaUiState != null)
                homeEvent.onNavigateToVerEntrenamiento(rutinaUiState!!)
                else//Mostrar snackbar
                    println("No hay rutina seleccionada")

            }


            else -> {}
        }
    }
}