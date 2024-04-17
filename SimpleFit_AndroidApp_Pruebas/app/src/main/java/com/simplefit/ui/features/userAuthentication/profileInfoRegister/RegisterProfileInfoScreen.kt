package com.simplefit.ui.features.userAuthentication.profileInfoRegister

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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.R
import com.simplefit.ui.features.userAuthentication.profileInfoRegister.components.RegisterProfileInfoForm
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RegisterProfileInfoScreen(
    registerProfileInfoUiState: RegisterProfileInfoUiState,
    mostrarSnack: Boolean,
    onMostrarSnackBar: () -> Unit,
    validacionRegisterProfileInfoUiState: ValidacionRegisterProfileInfoUiState,
    onRegisterProfileInfoEvent: (RegisterProfileInfoEvent) -> Unit,
    onNavigateToHome: ((correo: String) -> Unit)? = null,
    emailState: String
) {
    //Este email tiene que llegar desde AccountInfoRegister

    val scope = rememberCoroutineScope()
    Box() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {

            Spacer(modifier = Modifier.fillMaxHeight(0.01f))

            Text(
                text = "Completa tu perfil",
                color = Color(0xFFDAB338),
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic
            )


            RegisterProfileInfoForm(
                modifier = Modifier.fillMaxWidth(),
                edadState = registerProfileInfoUiState.edad,
                sexoState = registerProfileInfoUiState.sexo,
                somatotipoState = registerProfileInfoUiState.somatotipo,
                intoleranciaState = registerProfileInfoUiState.alergia,
                alturaState = registerProfileInfoUiState.altura,
                pesoState = registerProfileInfoUiState.peso,
                validacionAltura =  validacionRegisterProfileInfoUiState.validacionAltura,
                validacionPeso = validacionRegisterProfileInfoUiState.validacionPeso,
                onValueChangeEdad = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.EdadChanged(it))
                },
                onValueChangeSexo = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.SexoChanged(it))
                },
                onValueChangeSomatotipo = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.SomatotipoChanged(it))
                },
                onValueChangeAlergia = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.AlergiaChanged(it))
                },
                onValueChangeAltura = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.AlturaChanged(it))
                },
                onValueChangePeso = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.PesoChanged(it))
                }
            ) {
                onRegisterProfileInfoEvent(
                    RegisterProfileInfoEvent.OnClickGuardarPerfil(
                        onNavigateToHome
                    )
                )
                scope.launch {
                    delay(1000)
                    onMostrarSnackBar()
                }
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        }
        if (mostrarSnack) {
            var mensaje = ""
            if (validacionRegisterProfileInfoUiState.hayError) mensaje = validacionRegisterProfileInfoUiState.mensajeError ?: ""
            else mensaje = "Error, los datos introducidos no son correctos"
            Snackbar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(text = mensaje)
            }
        }
    }
}