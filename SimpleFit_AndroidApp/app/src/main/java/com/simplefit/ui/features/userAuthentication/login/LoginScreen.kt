package com.simplefit.ui.features.userAuthentication.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.recetas.ui.composables.TextNewAccount
import com.pmdm.tienda.ui.features.login.components.LoginForm
import com.simplefit.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    usuarioUiState: LoginUiState,
    validacionLoginUiState: ValidacionLoginUiState,
    mostrarSnack: Boolean,
    onLoginEvent: (LoginEvent) -> Unit,
    onMostrarSnackBar: () -> Unit,
    onNavigateToHome: ((correo: String) -> Unit)? = null,
    onNavigateToRegister: () -> Unit
) {

//    var mensaje by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    var recordarmeState by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box() {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
//                CircularImageFromResource(
//                    idImageResource = R.drawable.simplefit_logo, contentDescription = "Imagen Login"
//                )
                Text(
                    text = "SimpleFit",
                    color = Color(0xFFDAB338),
                    fontSize = 30.sp,
                    fontFamily = FontFamily(
                        Font(resId = R.font.bayon_regular)
                    )
                )


                LoginForm(modifier = Modifier.fillMaxWidth(),
                    loginState = usuarioUiState.email,
                    passwordState = usuarioUiState.password,
                    validacionLogin = validacionLoginUiState.validacionEmail,
                    validacionPassword = validacionLoginUiState.validacionPassword,
                    onValueChangeLogin = {
                        onLoginEvent(LoginEvent.EmailChanged(it))
                    },
                    onValueChangePassword = {
                        onLoginEvent(LoginEvent.PasswordChanged(it))
                    },
                    onClickLogearse = {
                        onLoginEvent(LoginEvent.OnClickLogearse(onNavigateToHome))
                        onMostrarSnackBar()
                        scope.launch() {
                            delay(4000)
                            onMostrarSnackBar()
                        }
                    })
                Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                TextNewAccount(
                    onNavigateToRegisterAccount = onNavigateToRegister,
                    color = Color.Black
                )
            }

            if (mostrarSnack) {
                var mensaje = ""
                if (validacionLoginUiState.hayError) mensaje =
                    validacionLoginUiState.mensajeError ?: ""
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
}

//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    val loginViewModel: LoginViewModel = viewModel()
//    SimpleFitTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
//        ) {
//
//            LoginScreen(usuarioUiState = loginViewModel.usuarioUiState,
//                validacionLoginUiState = loginViewModel.validacionLoginUiState,
//                onLoginEvent = loginViewModel::onLoginEvent,
//                mostrarSnack = false,
//                onNavigateToHome = {},
//                onMostrarSnackBar = {},
//                onNavigateToRegister = {},
//                )
//        }
//    }
//}