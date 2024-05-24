package com.simplefit.ui.features.mainApp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.ui.composables.ImageSelector
import com.simplefit.R
import com.simplefit.ui.composables.HeaderConsejos
import com.simplefit.ui.composables.HomeButton
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import kotlinx.coroutines.delay
import java.util.Calendar
import java.util.Locale

fun obtenerDiaDeLaSemana(): String {
    val dias = arrayOf("D", "L", "M", "X", "J", "V", "S")
    val calendario = Calendar.getInstance()
    val diaDeLaSemana = calendario.get(Calendar.DAY_OF_WEEK)
    return dias[diaDeLaSemana - 1]
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    onHomeEvent: (HomeEvent) -> Unit,
    onNavigateToVerEntrenamiento: ((rutina: RoutinesUiState) -> Unit),
    consejos: List<String>,
    mostrarSnack: Boolean,
    onMostrarSnackbar: () -> Unit

    ) {
    val diasDeLaSemana = arrayOf("L", "M", "X", "J", "V", "S", "D")
    val diaActual = obtenerDiaDeLaSemana()
    Box()
    {


        Column {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(
                        color = Color(0xFFDBC06D),
                        shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                    )
            ) {
                Row()
                {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(start = 50.dp, 40.dp)
                    ) {
                        Text(
                            text = "Hola,\n",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal
                        )
                        Text(
                            homeUiState.nombre.split(" ")[0].replaceFirstChar { it.uppercase(Locale.getDefault()) },
                            color = Color.White,
                            fontSize = 30.sp,
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            modifier = Modifier.size(175.dp)
                        )
                    }
                    ImageSelector(
                        modifier = Modifier.padding(top = 30.dp),
                        selectImageBitmap = homeUiState.foto,
                        onImageChanged = {onHomeEvent(HomeEvent.OnCambiarfoto(it))}
                    )

                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Row( //Las bolas de los dias de la semana
                    Modifier
                        .height(55.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(diasDeLaSemana.size) { iteration ->
                        val colorDeFondo =
                            if (diasDeLaSemana[iteration] == diaActual) Color(0xFFDAB338) else Color(
                                0xFFDCCEA2
                            )
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(colorDeFondo)
                                .size(30.dp),
                            contentAlignment = Alignment.Center,
                        )
                        {
                            Text(
                                text = diasDeLaSemana[iteration],
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        }
                    }
                }
                HeaderConsejos(
                    modifier = Modifier,
                    consejos = consejos
                )


                HomeButton(
                    onNavigateToVerEntrenamiento = onNavigateToVerEntrenamiento,
                    texto = "VER ENTRENAMIENTO",
                    foto = painterResource(id = R.drawable.ver_entrenamiento_3),
                    onHomeEvent = onHomeEvent,
                )



                Spacer(modifier = Modifier.height(25.dp))
                HomeButton(
                    texto = "RECOMENDAR AMIGOS",
                    foto = painterResource(id = R.drawable.compartir_background),
                    onHomeEvent = onHomeEvent
                )
                Spacer(modifier = Modifier.height(55.dp))

            }
        }
        LaunchedEffect(mostrarSnack) {
            if (mostrarSnack) {
                delay(3000L)
                onMostrarSnackbar()
            }
        }

        if (mostrarSnack) {
            Snackbar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(text = "No tienes rutina activa")
            }
        }

    }

}