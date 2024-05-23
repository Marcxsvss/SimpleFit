package com.simplefit.ui.features.userAuthentication.accountInfoRegister

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
    var validacionRegisterAccountInfoUiState by mutableStateOf(ValidacionRegisterAccountInfoUiState())
        private set
    var mostrarSnackBar by mutableStateOf(false)
    val onMostrarSnackBar: () -> Unit by mutableStateOf({
        mostrarSnackBar = !mostrarSnackBar
    })

    fun onRegisterAccountInfoEvent(registerAccountInfoEvent: RegisterAccountInfoEvent) {
        when (registerAccountInfoEvent) {
            is RegisterAccountInfoEvent.EmailChanged -> {
                viewModelScope.launch {

                        nuevoUsuarioUiState = nuevoUsuarioUiState.copy(
                            email = registerAccountInfoEvent.email
                        )
                        validacionRegisterAccountInfoUiState = validacionRegisterAccountInfoUiState.copy(

                            validacionEmail = validadorRegisterAccountInfo.validadorEmail.valida(registerAccountInfoEvent.email)


                        )
                   }

            }
            is RegisterAccountInfoEvent.PasswordChanged -> {
                nuevoUsuarioUiState = nuevoUsuarioUiState.copy(
                    password = registerAccountInfoEvent.password
                )
                validacionRegisterAccountInfoUiState = validacionRegisterAccountInfoUiState.copy(
                    validacionPassword = validadorRegisterAccountInfo.validadorPassword.valida(registerAccountInfoEvent.password)
                )
            }
            is RegisterAccountInfoEvent.NombreChanged -> {
                nuevoUsuarioUiState = nuevoUsuarioUiState.copy(
                    nombre = registerAccountInfoEvent.nombre
                )
                validacionRegisterAccountInfoUiState = validacionRegisterAccountInfoUiState.copy(
                    validacionNombre = validadorRegisterAccountInfo.validadorNombre.valida(registerAccountInfoEvent.nombre)
                )
            }

            is RegisterAccountInfoEvent.OnClickRegistrarse -> {
                viewModelScope.launch {
                    validacionRegisterAccountInfoUiState = validadorRegisterAccountInfo.valida(nuevoUsuarioUiState)
                    if (!validacionRegisterAccountInfoUiState.hayError) {

                        nuevoUsuarioUiState = nuevoUsuarioUiState.copy(
                            estaRegistrado = registro()
                        )
                        if (!nuevoUsuarioUiState.estaRegistrado) {
                            delay(1000)
                            registerAccountInfoEvent.onNavigateRegisterProfileInfo?.let { it(nuevoUsuarioUiState.email) }
                        }
                    }
                }
            }

            else -> {}
        }
    }

    suspend fun registro(): Boolean {
        val usuario = nuevoUsuarioUiState.toUsuario()

        return if(usuarioRepository.get(usuario.email)?.email == usuario.email) {
            true
        } else {
            usuarioRepository.insert(usuario)
            false
        }



    }

}