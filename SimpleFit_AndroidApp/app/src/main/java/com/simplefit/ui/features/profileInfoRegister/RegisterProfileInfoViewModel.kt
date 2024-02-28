package com.simplefit.ui.features.profileInfoRegister

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
    var perfilUsuarioUiState by mutableStateOf(RegisterProfileInfoUiState())
        private set
    var validacionRegisterProfileInfoUiState by mutableStateOf(ValidacionRegisterProfileInfoUiState())
        private set
    var mostrarSnackBar by mutableStateOf(false)
    val onMostrarSnackBar: () -> Unit by mutableStateOf({
        mostrarSnackBar = !mostrarSnackBar
    })

    fun onRegisterProfileInfoEvent(registerProfileInfoEvent: RegisterProfileInfoEvent) {
        when (registerProfileInfoEvent) {
            is RegisterProfileInfoEvent.EmailChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    email = registerProfileInfoEvent.login
                )
                validacionRegisterProfileInfoUiState = validacionRegisterProfileInfoUiState.copy(
                    validacionEmail = validadorRegisterProfileInfo.validadorEmail.valida(registerProfileInfoEvent.login)
                )
            }

            is RegisterProfileInfoEvent.PasswordChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    password = registerProfileInfoEvent.password
                )
                validacionRegisterProfileInfoUiState = validacionRegisterProfileInfoUiState.copy(
                    validacionPassword = validadorRegisterProfileInfo.validadorPassword.valida(registerProfileInfoEvent.password)
                )
            }
            is RegisterProfileInfoEvent.DniChanged -> {
                perfilUsuarioUiState = perfilUsuarioUiState.copy(
                    password = registerProfileInfoEvent.dni
                )
                validacionRegisterProfileInfoUiState = validacionRegisterProfileInfoUiState.copy(
                    validacionPassword = validadorRegisterProfileInfo.validadorPassword.valida(registerProfileInfoEvent.dni)
                )
            }

            is RegisterProfileInfoEvent.OnClickGuardarPerfil -> {
                viewModelScope.launch {
                    validacionRegisterProfileInfoUiState = validadorRegisterProfileInfo.valida(perfilUsuarioUiState)
                    if (!validacionRegisterProfileInfoUiState.hayError) {

                        perfilUsuarioUiState = perfilUsuarioUiState.copy(
                            //estaRegistrado = registro()
                        )
//                        if (nuevoUsuarioUiState.estaRegistrado) {
//                            delay(1000)
//                            registerAccountInfoEvent.onNavigateHome?.let { it(nuevoUsuarioUiState.email) }
//                        }
                    }
                }
            }

            else -> {}
        }
    }

    suspend fun registro(): Boolean {
        val usuario = perfilUsuarioUiState.toUsuario()

        if (usuarioRepository.get(usuario.email) == null)
        {
            usuarioRepository.insert(usuario)
            return true
        }
        else
        {
            return false
        }

    }

}