package com.simplefit.ui.features.profileInfoRegister

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pmdm.recetas.ui.composables.CircularImageFromResource
import com.simplefit.R
import com.simplefit.ui.features.profileInfoRegister.components.RegisterProfileInfoForm
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
            CircularImageFromResource(
                idImageResource = R.drawable.login, contentDescription = "Imagen Login"
            )


            RegisterProfileInfoForm(
                modifier = Modifier.fillMaxWidth(),
                edadState = registerProfileInfoUiState.edad,
                sexoState = registerProfileInfoUiState.sexo,
                somatotipoState = registerProfileInfoUiState.somatotipo,
                alergiaState = registerProfileInfoUiState.alergia,
                alturaState = registerProfileInfoUiState.altura,
                pesoState= registerProfileInfoUiState.peso,
                validacionAltura=  validacionRegisterProfileInfoUiState.validacionAltura,
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
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.AlturaChanged(it.toInt()))
                },
                onValueChangePeso = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.PesoChanged(it.toInt()))
                },
                onClickGuardar = {
                    onRegisterProfileInfoEvent(RegisterProfileInfoEvent.OnClickGuardarPerfil(onNavigateToHome))
                    scope.launch {
                        delay(1000)
                        //onMostrarSnackBar()
                    }
                })
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        }
//        if (mostrarSnack) {
//            var mensaje = ""
//            if (validacionRegisterProfileInfoUiState.hayError) mensaje = validacionRegisterProfileInfoUiState.mensajeError ?: ""
//            else if (registerProfileInfoUiState.estaRegistrado) mensaje =
//                "Entrando a la APP con usuario ${registerProfileInfoUiState.email}"
//            else mensaje = "Error, el email usuario ya está registrado"
//            Snackbar(
//                modifier = Modifier.align(Alignment.BottomCenter)
//            ) {
//                Text(text = mensaje)
//            }
//        }
    }
}