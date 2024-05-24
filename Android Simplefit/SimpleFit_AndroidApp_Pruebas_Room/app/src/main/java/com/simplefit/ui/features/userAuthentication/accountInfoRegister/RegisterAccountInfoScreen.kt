package com.simplefit.ui.features.userAuthentication.accountInfoRegister

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.R
import com.simplefit.ui.features.userAuthentication.accountInfoRegister.components.RegisterAccountInfoForm
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RegisterAccountInfoScreen(
    registerAccountInfoUiState: RegisterAccountInfoUiState,
    mostrarSnack: Boolean,
    onMostrarSnackBar: () -> Unit,
    validacionRegisterAccountInfoUiState: ValidacionRegisterAccountInfoUiState,
    onRegisterAccountInfoEvent: (RegisterAccountInfoEvent) -> Unit,
    onNavigateToRegisterProfileInfo: ((correo: String) -> Unit)?,
    onNavigateToLogin: () -> Unit
) {

    val scope = rememberCoroutineScope()
    Box() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "REGISTRO",
                color = Color(0xFFDAB338),
                fontSize = 30.sp,
                fontFamily = FontFamily(
                    Font(resId = R.font.bayon_regular)
                )
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.04f))


            RegisterAccountInfoForm(modifier = Modifier.fillMaxWidth(),
                emailState = registerAccountInfoUiState.email,
                passwordState = registerAccountInfoUiState.password,
                nombreState = registerAccountInfoUiState.nombre,
                validacionEmail = validacionRegisterAccountInfoUiState.validacionEmail,
                validacionPassword = validacionRegisterAccountInfoUiState.validacionPassword,
                validacionNombre = validacionRegisterAccountInfoUiState.validacionNombre,
                onValueChangeEmail = {
                    onRegisterAccountInfoEvent(RegisterAccountInfoEvent.EmailChanged(it))
                },
                onValueChangePassword = {
                    onRegisterAccountInfoEvent(RegisterAccountInfoEvent.PasswordChanged(it))
                },
                onValueChangeNombre = { onRegisterAccountInfoEvent(RegisterAccountInfoEvent.NombreChanged(it)) },
                onClickRegistrarse = {
                    onRegisterAccountInfoEvent(RegisterAccountInfoEvent.OnClickRegistrarse(onNavigateToRegisterProfileInfo))
                    onMostrarSnackBar()
                    scope.launch() {
                        delay(4000)
                        onMostrarSnackBar()
                    }
                }
                )
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        }
        if (mostrarSnack) {
            var mensaje = ""
            if (validacionRegisterAccountInfoUiState.hayError) mensaje = validacionRegisterAccountInfoUiState.mensajeError ?: ""
            else if (!registerAccountInfoUiState.estaRegistrado) mensaje =
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