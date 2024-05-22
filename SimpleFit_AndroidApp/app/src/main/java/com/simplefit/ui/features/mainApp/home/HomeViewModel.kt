package com.simplefit.ui.features.mainApp.home

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.agenda.utilities.imagenes.Imagenes
import com.simplefit.data.ConsejosRepository
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.models.Usuario
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


    fun onChangePhoto(image: ImageBitmap?) {
        homeUiState = homeUiState.copy(
            foto = image
        )
        usuario = usuario.copy(foto =  Imagenes.bitmapToBase64(image!!))
        viewModelScope.launch { usuarioRepository.update(usuario) }
    }
    var mostrarSnackBar by mutableStateOf(false)
    val onMostrarSnackBar: () -> Unit by mutableStateOf({
        mostrarSnackBar = !mostrarSnackBar
    })
    var usuario by mutableStateOf(Usuario())
        private set
    fun setUsuario(email : String)
    {
        viewModelScope.launch {

            usuario = usuarioRepository.get(email)!!
            if (usuario != null) {
                homeUiState = homeUiState.copy(
                    email = usuario.email,
                    nombre = usuario.nombre,
                    foto = if (usuario.foto != null) Imagenes.base64ToBitmap(usuario.foto!!) else null
                )
                if(usuario.rutinaState != null && usuario.rutinaState != 0)
                {
                    rutinaUiState = rutinasRepository.getRutina(usuario.rutinaState).toRutinasUiState()
                }
                else
                {
                    rutinaUiState = null
                }

            }

            consejos = ConsejosRepository.get()
        }
    }
    fun onHomeEvent(homeEvent: HomeEvent) {
        when (homeEvent) {
            is HomeEvent.onVerEntrenamientoClicked -> {
                if(rutinaUiState != null)
                    homeEvent.onNavigateToVerEntrenamiento?.let { it(rutinaUiState!!) }
                else
                    mostrarSnackBar = !mostrarSnackBar

            }
            is HomeEvent.OnCambiarfoto -> {
                onChangePhoto(homeEvent.image)
            }


            else -> {}
        }
    }
}