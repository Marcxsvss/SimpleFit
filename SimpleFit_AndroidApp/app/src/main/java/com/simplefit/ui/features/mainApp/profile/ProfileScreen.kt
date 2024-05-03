package com.simplefit.ui.features.mainApp.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
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
fun ProfileScreen(
    mostrarSnack: Boolean,
    onMostrarSnackBar: () -> Unit,
    validacionProfileUiState: ValidacionProfileUiState,
    onNavigateToLogin: () -> Unit,
    profileUiState: ProfileUiState,
    onProfileEvent: (ProfileEvent) -> Unit
) {
    val scope = rememberCoroutineScope()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(contentAlignment = Alignment.TopEnd)
        {
            IconButton(onClick = { onNavigateToLogin() }) {
                Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Cerrar sesión",
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "SimpleFit",
                    color = Color(0xFFDAB338),
                    fontSize = 30.sp,
                    fontFamily = FontFamily(
                        Font(resId = R.font.bayon_regular)
                    )
                )
                Text(
                    text = "Preferecias de usuario",
                    color = Color(0xFFDAB338),
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.05f))

                RegisterProfileInfoForm(
                    modifier = Modifier.fillMaxWidth(),
                    edadState = profileUiState.edad,
                    sexoState = profileUiState.sexo,
                    somatotipoState = profileUiState.somatotipo,
                    alturaState = profileUiState.altura,
                    pesoState = profileUiState.peso,
                    validacionAltura = validacionProfileUiState.validacionAltura,
                    validacionPeso = validacionProfileUiState.validacionPeso,
                    onValueChangeEdad = {
                        onProfileEvent(ProfileEvent.EdadChanged(it))
                    },
                    onValueChangeSexo = {
                        onProfileEvent(ProfileEvent.SexoChanged(it))
                    },
                    onValueChangeSomatotipo = {
                        onProfileEvent(ProfileEvent.SomatotipoChanged(it))
                    },
                    onValueChangeAltura = {
                        onProfileEvent(ProfileEvent.AlturaChanged(it))
                    },
                    onValueChangePeso = {
                        onProfileEvent(ProfileEvent.PesoChanged(it))
                    },
                )
                {
                    onProfileEvent(
                        ProfileEvent.onClickGuardarPerfil
                    )

                    scope.launch {
                        delay(1000)
                        onMostrarSnackBar()
                    }
                }
                Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            }
            if (mostrarSnack) {
                var mensaje = "Error"
                if (validacionProfileUiState.hayError) mensaje = validacionProfileUiState.mensajeError ?: ""
                else mensaje = "Error, los datos introducidos no son correctos"
                Snackbar(
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Text(text = mensaje)
                }
            }
        }
    }
}