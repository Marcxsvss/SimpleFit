package com.simplefit.ui.features.userAuthentication.profileInfoRegister

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.UsuarioRepository
import com.simplefit.ui.features.toUsuario
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterProfileInfoViewModel @Inject constructor(
    private val validadorRegisterProfileInfo: ValidadorRegisterProfileInfo,
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var accountMail by mutableStateOf("")
    var perfilUsuarioUiState by mutableStateOf(RegisterProfileInfoUiState())
    var validacionRegisterProfileInfoUiState by mutableStateOf(ValidacionRegisterProfileInfoUiState())
        private set
    var mostrarSnackBar by mutableStateOf(false)
    val onMostrarSnackBar: () -> Unit by mutableStateOf({
        mostrarSnackBar = !mostrarSnackBar
    })

//    fun setUsuario(email : String)
//    {
//        perfilUsuarioUiState = perfilUsuarioUiState.copy(
//            email = email
//        )
//    }
    fun onRegisterProfileInfoEvent(registerProfileInfoEvent: RegisterProfileInfoEvent) {
        when (registerProfileInfoEvent) {
            is RegisterProfileInfoEvent.EdadChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    edad = registerProfileInfoEvent.edad
                )
            }
            is RegisterProfileInfoEvent.AlergiaChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    alergia = registerProfileInfoEvent.alergia
                )
            }
            is RegisterProfileInfoEvent.SexoChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    sexo = registerProfileInfoEvent.sexo
                )
            }
            is RegisterProfileInfoEvent.SomatotipoChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    somatotipo = registerProfileInfoEvent.somatotipo
                )
            }
            is RegisterProfileInfoEvent.PesoChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    peso = registerProfileInfoEvent.peso
                )
                validacionRegisterProfileInfoUiState = validacionRegisterProfileInfoUiState.copy(
                    validacionPeso = validadorRegisterProfileInfo.validadorPeso.valida(registerProfileInfoEvent.peso.toString())
                )
            }
            is RegisterProfileInfoEvent.AlturaChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    altura = registerProfileInfoEvent.altura
                )
                validacionRegisterProfileInfoUiState = validacionRegisterProfileInfoUiState.copy(
                    validacionAltura = validadorRegisterProfileInfo.validadorAltura.valida(registerProfileInfoEvent.altura.toString())
                )
            }

            is RegisterProfileInfoEvent.OnClickGuardarPerfil -> {
                viewModelScope.launch {
                    validacionRegisterProfileInfoUiState = validadorRegisterProfileInfo.valida(perfilUsuarioUiState)
                    if (!validacionRegisterProfileInfoUiState.hayError) {


                        perfilUsuarioUiState = perfilUsuarioUiState.copy(
                            email = accountMail
                        )
                        val usuario = usuarioRepository.get(perfilUsuarioUiState.email)?.copy(
                            edad = perfilUsuarioUiState.edad,
                            altura = perfilUsuarioUiState.altura,
                            peso = perfilUsuarioUiState.peso,
                            sexo = perfilUsuarioUiState.sexo,
                            somatotipo = perfilUsuarioUiState.somatotipo)
                        usuarioRepository.update(usuario!!)

                        delay(1000)
                        registerProfileInfoEvent.onNavigateHome?.let { it(perfilUsuarioUiState.email) }

                    }
                }
            }

            else -> {}
        }
    }

//    suspend fun registro(): Boolean {
//        val usuario = perfilUsuarioUiState.toUsuario()
//
//        if (usuarioRepository.get(usuario.email) == null)
//        {
//            usuarioRepository.insert(usuario)
//            return true
//        }
//        else
//        {
//            return false
//        }
//
//    }

}