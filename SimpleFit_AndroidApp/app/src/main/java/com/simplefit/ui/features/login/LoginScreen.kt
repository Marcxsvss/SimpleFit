package com.simplefit.ui.features.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.recetas.ui.composables.CircularImageFromResource
import com.pmdm.recetas.ui.composables.TextNewAccount
import com.pmdm.tienda.ui.features.login.ValidacionLoginUiState
import com.pmdm.tienda.ui.features.login.components.UsuarioPassword
import com.simplefit.R
import com.simplefit.ui.theme.Purple40
import com.simplefit.ui.theme.SimpleFitTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    usuarioUiState: LoginUiState,
    validacionLoginUiState: ValidacionLoginUiState,
    mostrarSnack: Boolean,
    onLoginEvent: (LoginEvent) -> Unit,
    onMostrarSnackBar: () -> Unit,
    onNavigateToRecetas: ((correo: String) -> Unit)? = null,
    ) {

//    var mensaje by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    var recordarmeState by remember { mutableStateOf(false) }

    Box() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            CircularImageFromResource(
                idImageResource = R.drawable.login, contentDescription = "Imagen Login"
            )


            UsuarioPassword(modifier = Modifier.fillMaxWidth(),
                loginState = usuarioUiState.email,
                passwordState = usuarioUiState.password,
                validacionLogin = validacionLoginUiState.validacionEmail,
                validacionPassword = validacionLoginUiState.validacionPassword,
                recordarmeState = recordarmeState,
                onValueChangeLogin = {
                    onLoginEvent(LoginEvent.LoginChanged(it))
                },
                onValueChangePassword = {
                    onLoginEvent(LoginEvent.PasswordChanged(it))
                },
                onCheckedChanged = { recordarmeState = it },
                onClickLogearse = {
                    onLoginEvent(LoginEvent.OnClickLogearse(onNavigateToRecetas))
                    onMostrarSnackBar()
                    scope.launch() {
                        delay(4000)
                        onMostrarSnackBar()
                    }
                })
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            Text(
                "Olvidaste la contraseña?",
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                color = Purple40
            )
            TextNewAccount(onClick = {
            })
        }
        if (mostrarSnack) {
            var mensaje = ""
            if (validacionLoginUiState.hayError) mensaje = validacionLoginUiState.mensajeError ?: ""
            else if (usuarioUiState.estaLogeado) mensaje =
                "Entrando a la APP con usuario ${usuarioUiState.email}"
            else mensaje = "Error, no existe el usuario o contraseña incorrecta"
            Snackbar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(text = mensaje)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val loginViewModel: LoginViewModel = viewModel()
    SimpleFitTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {

            LoginScreen(usuarioUiState = loginViewModel.usuarioUiState,
                validacionLoginUiState = loginViewModel.validacionLoginUiState,
                onLoginEvent = loginViewModel::onLoginEvent,
                mostrarSnack = false,
                onNavigateToRecetas = {},
                onMostrarSnackBar = {})
        }
    }
}