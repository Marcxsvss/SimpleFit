package com.simplefit.ui.features.userAuthentication.login

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
class LoginViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository,
    private val validadorLogin: ValidadorLogin
) : ViewModel() {

    var usuarioUiState by mutableStateOf(LoginUiState())
        private set
    var validacionLoginUiState by mutableStateOf(ValidacionLoginUiState())
        private set
    var mostrarSnackBar by mutableStateOf(false)
    val onMostrarSnackBar: () -> Unit by mutableStateOf({
        mostrarSnackBar = !mostrarSnackBar
    })

    fun onLoginEvent(loginEvent: LoginEvent) {
        when (loginEvent) {
            is LoginEvent.EmailChanged -> {
                usuarioUiState = usuarioUiState.copy(
                    email = loginEvent.login
                )
                validacionLoginUiState = validacionLoginUiState.copy(
                    validacionEmail = validadorLogin.validadorEmail.valida(loginEvent.login)
                )
            }

            is LoginEvent.PasswordChanged -> {
                usuarioUiState = usuarioUiState.copy(
                    password = loginEvent.password
                )
                validacionLoginUiState = validacionLoginUiState.copy(
                    validacionPassword = validadorLogin.validadorPassword.valida(loginEvent.password)
                )
            }

            is LoginEvent.OnClickLogearse -> {
                viewModelScope.launch {
                    validacionLoginUiState = validadorLogin.valida(usuarioUiState)
                    if (!validacionLoginUiState.hayError) {

                        usuarioUiState = usuarioUiState.copy(
                            estaLogeado = logearse()
                        )
                        if (usuarioUiState.estaLogeado) {
                            delay(1000)
                            loginEvent.onNavigateTienda?.let { it(usuarioUiState.email) }
                        }
                    }
                }

            }

            else -> {}
        }
    }

    suspend fun logearse(): Boolean {
        val usuario = usuarioUiState.toUsuario()
        val usuarioRepository = usuarioRepository.get(usuario.email)
        if (usuarioRepository != null && usuarioRepository.password == usuario.password) return true
        return false
    }

    fun iniciaUsuario(correo: String?) {
        if (correo != null) usuarioUiState = LoginUiState(correo, "", false)
        else usuarioUiState = LoginUiState()
        mostrarSnackBar = false
    }

    fun clearLogin() {
        usuarioUiState = LoginUiState()
    }


}