package com.simplefit.ui.features.accountInfoRegister

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
fun RegisterAccountInfoScreen(
    registerAccountInfoUiState : RegisterAccountInfoUiState,
    mostrarSnack: Boolean,
    onMostrarSnackBar: () -> Unit,
    validacionRegisterAccountInfoUiState: ValidacionRegisterAccountInfoUiState,
    onRegisterAccountInfoEvent: (RegisterAccountInfoEvent) -> Unit,
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
                emailState = registerAccountInfoUiState.email,
                passwordState = registerAccountInfoUiState.password,
                dniState = registerAccountInfoUiState.dni,
                validacionEmail = validacionRegisterAccountInfoUiState.validacionEmail,
                validacionPassword = validacionRegisterAccountInfoUiState.validacionPassword,
                validacionDni = validacionRegisterAccountInfoUiState.validacionDni,
                onValueChangeEmail = {
                    onRegisterAccountInfoEvent(RegisterAccountInfoEvent.EmailChanged(it))
                },
                onValueChangePassword = {
                    onRegisterAccountInfoEvent(RegisterAccountInfoEvent.PasswordChanged(it))
                },
                onValueChangeDni = { onRegisterAccountInfoEvent(RegisterAccountInfoEvent.DniChanged(it)) },
                onClickRegistrarse = {
                    onRegisterAccountInfoEvent(RegisterAccountInfoEvent.OnClickRegistrarse(onNavigateToHome))
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
            if (validacionRegisterAccountInfoUiState.hayError) mensaje = validacionRegisterAccountInfoUiState.mensajeError ?: ""
            else if (registerAccountInfoUiState.estaRegistrado) mensaje =
                "Entrando a la APP con usuario ${registerAccountInfoUiState.email}"
            else mensaje = "Error, el email usuario ya está registrado"
            Snackbar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(text = mensaje)
            }
        }
    }
}