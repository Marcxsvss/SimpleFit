package com.simplefit.ui.features.mainApp.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.UsuarioRepository
import com.simplefit.ui.features.userAuthentication.profileInfoRegister.ValidacionRegisterProfileInfoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val validadorProfile: ValidadorProfile,
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {

    //var accountMail by mutableStateOf("")

    var profileUiState by mutableStateOf(ProfileUiState())
        private set
    var validacionProfileUiState by mutableStateOf(ValidacionProfileUiState())
        private set
    var mostrarSnackBar by mutableStateOf(false)

    val onMostrarSnackBar: () -> Unit by mutableStateOf({
        mostrarSnackBar = !mostrarSnackBar
    })


    fun setUserEmail(email: String) {
        profileUiState.email = email
        viewModelScope.launch {
            val usuario = usuarioRepository.get(email)
            if (usuario != null) {
                profileUiState = profileUiState.copy(
                    edad = usuario.edad,
                    altura = usuario.altura,
                    peso = usuario.peso,
                    sexo = usuario.sexo,
                    somatotipo = usuario.somatotipo,
                    intolerancia = usuario.intolerancia ?: ""
                )
            }
        }
    }

    fun onProfileEvent(profileEvent: ProfileEvent) {
        when (profileEvent) {
            is ProfileEvent.onClickLogOut -> {

            }

            is ProfileEvent.EdadChanged -> {
                profileUiState = profileUiState.copy(
                    edad = profileEvent.edad
                )
            }

            is ProfileEvent.IntoleranciaChanged -> {
                profileUiState = profileUiState.copy(
                    intolerancia = profileEvent.intolerancia
                )
            }

            is ProfileEvent.SexoChanged -> {
                profileUiState = profileUiState.copy(
                    sexo = profileEvent.sexo
                )
            }

            is ProfileEvent.SomatotipoChanged -> {
                profileUiState = profileUiState.copy(
                    somatotipo = profileEvent.somatotipo
                )
            }

            is ProfileEvent.PesoChanged -> {
                profileUiState = profileUiState.copy(
                    peso = profileEvent.peso
                )
                validacionProfileUiState = validacionProfileUiState.copy(
                    validacionPeso = validadorProfile.validadorPeso.valida(profileEvent.peso)
                )
            }

            is ProfileEvent.AlturaChanged -> {
                profileUiState = profileUiState.copy(
                    altura = profileEvent.altura
                )
                validacionProfileUiState = validacionProfileUiState.copy(
                    validacionAltura = validadorProfile.validadorAltura.valida(profileEvent.altura)
                )
            }

            is ProfileEvent.onClickGuardarPerfil -> {
                viewModelScope.launch {
                    validacionProfileUiState = validadorProfile.valida(profileUiState)
                    if (!validacionProfileUiState.hayError) {


                        val usuario = usuarioRepository.get(profileUiState.email)?.copy(
                            edad = profileUiState.edad,
                            altura = profileUiState.altura,
                            peso = profileUiState.peso,
                            sexo = profileUiState.sexo,
                            somatotipo = profileUiState.somatotipo,
                            intolerancia = profileUiState.intolerancia
                        )
                        usuarioRepository.update(usuario!!)

                    }
                }
            }

            else -> {}
        }
    }
}