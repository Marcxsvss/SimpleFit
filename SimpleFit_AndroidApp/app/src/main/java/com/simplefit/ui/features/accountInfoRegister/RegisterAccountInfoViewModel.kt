package com.simplefit.ui.features.accountInfoRegister

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
class RegisterAccountInfoViewModel @Inject constructor(
    private val validadorRegisterAccountInfo: ValidadorRegisterAccountInfo,
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var nuevoUsuarioUiState by mutableStateOf(RegisterAccountInfoUiState())
        private set
    var validacionRegisterProfileInfoUiState by mutableStateOf(ValidacionRegisterAccountInfoUiState())
        private set
    var mostrarSnackBar by mutableStateOf(false)
    val onMostrarSnackBar: () -> Unit by mutableStateOf({
        mostrarSnackBar = !mostrarSnackBar
    })

    fun onRegisterAccountInfoEvent(registerAccountInfoEvent: RegisterAccountInfoEvent) {
        when (registerAccountInfoEvent) {
            is RegisterAccountInfoEvent.EmailChanged -> {
                nuevoUsuarioUiState = nuevoUsuarioUiState.copy(
                    email = registerAccountInfoEvent.login
                )
                validacionRegisterProfileInfoUiState = validacionRegisterProfileInfoUiState.copy(
                    validacionEmail = validadorRegisterAccountInfo.validadorEmail.valida(registerAccountInfoEvent.login)
                )
            }

            is RegisterAccountInfoEvent.PasswordChanged -> {
                nuevoUsuarioUiState = nuevoUsuarioUiState.copy(
                    password = registerAccountInfoEvent.password
                )
                validacionRegisterProfileInfoUiState = validacionRegisterProfileInfoUiState.copy(
                    validacionPassword = validadorRegisterAccountInfo.validadorPassword.valida(registerAccountInfoEvent.password)
                )
            }
            is RegisterAccountInfoEvent.DniChanged -> {
                nuevoUsuarioUiState = nuevoUsuarioUiState.copy(
                    password = registerAccountInfoEvent.dni
                )
                validacionRegisterProfileInfoUiState = validacionRegisterProfileInfoUiState.copy(
                    validacionPassword = validadorRegisterAccountInfo.validadorPassword.valida(registerAccountInfoEvent.dni)
                )
            }

            is RegisterAccountInfoEvent.OnClickRegistrarse -> {
                viewModelScope.launch {
                    validacionRegisterProfileInfoUiState = validadorRegisterAccountInfo.valida(nuevoUsuarioUiState)
                    if (!validacionRegisterProfileInfoUiState.hayError) {

                        nuevoUsuarioUiState = nuevoUsuarioUiState.copy(
                            estaRegistrado = registro()
                        )
                        if (nuevoUsuarioUiState.estaRegistrado) {
                            delay(1000)
                            registerAccountInfoEvent.onNavigateHome?.let { it(nuevoUsuarioUiState.email) }
                        }
                    }
                }
            }

            else -> {}
        }
    }

    suspend fun registro(): Boolean {
        val usuario = nuevoUsuarioUiState.toUsuario()

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