package com.simplefit.ui.features.profileInfoRegister

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pmdm.recetas.ui.composables.CircularImageFromResource
import com.pmdm.recetas.ui.composables.TextNewAccount
import com.simplefit.R
import com.simplefit.ui.features.accountInfoRegister.components.RegisterAccountInfoForm
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RegisterProfileInfoScreen(
    registerProfileInfoUiState : RegisterProfileInfoUiState,
    mostrarSnack: Boolean,
    onMostrarSnackBar: () -> Unit,
    validacionRegisterProfileInfoUiState: ValidacionRegisterProfileInfoUiState,
    onRegisterProfileInfoEvent: (RegisterProfileInfoEvent) -> Unit,
    onNavigateToHome: ((correo: String) -> Unit)? = null) {

    val scope = rememberCoroutineScope()
    Box() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            CircularImageFromResource(
                idImageResource = R.drawable.login, contentDescription = "Imagen Login"
            )


            RegisterAccountInfoForm(modifier = Modifier.fillMaxWidth(),
                emailState = registerProfileInfoUiState.email,
                passwordState = registerProfileInfoUiState.password,
                dniState = registerProfileInfoUiState.dni,
                validacionEmail = validacionRegisterProfileInfoUiState.validacionEmail,
                validacionPassword = validacionRegisterProfileInfoUiState.validacionPassword,
                validacionDni = validacionRegisterProfileInfoUiState.validacionDni,
                onValueChangeEmail = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.EmailChanged(it))
                },
                onValueChangePassword = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.PasswordChanged(it))
                },
                onValueChangeDni = { onRegisterProfileInfoEvent(RegisterProfileInfoEvent.DniChanged(it)) },
                onClickRegistrarse = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.OnClickGuardarPerfil(onNavigateToHome))
                    onMostrarSnackBar()
                    scope.launch() {
                        delay(4000)
                        onMostrarSnackBar()
                    }
                })
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            TextNewAccount(onClick = {
            })
        }
        if (mostrarSnack) {
            var mensaje = ""
            if (validacionRegisterProfileInfoUiState.hayError) mensaje = validacionRegisterProfileInfoUiState.mensajeError ?: ""
            else if (registerProfileInfoUiState.estaRegistrado) mensaje =
                "Entrando a la APP con usuario ${registerProfileInfoUiState.email}"
            else mensaje = "Error, el email usuario ya está registrado"
            Snackbar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(text = mensaje)
            }
        }
    }
}