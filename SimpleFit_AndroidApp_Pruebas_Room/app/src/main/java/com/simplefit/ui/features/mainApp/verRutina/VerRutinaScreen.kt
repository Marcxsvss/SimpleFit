package com.simplefit.ui.features.mainApp.verRutina

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Face2
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.simplefit.R
import com.simplefit.ui.composables.DescansoScreen
import com.simplefit.ui.features.mainApp.MaquinaUiState
import kotlinx.coroutines.delay
import java.util.Calendar


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerRoutinesScreen(
    verRutinaState: VerRutinaUiState,
    onVerRutinaEvent: (VerRutinaEvent) -> Unit,
    diaSeleccionado: String,
    mostrarDialog: Boolean,
    onMostrarDialog: (Boolean) -> Unit,
    maquinaUiState: MaquinaUiState,
    onNavigateToPrevious: () -> Unit,
    onNavigateToRutinas: ((userid: String) -> Unit)? = null,
    mostrarSnack: Boolean,
    onMostrarSnackbar: () -> Unit

    ) {

    val imagenSinFoto = rememberVectorPainter(image = Icons.Filled.Face2)
    var painterFoto = remember(maquinaUiState.imagen) {
        maquinaUiState.imagen?.let { BitmapPainter(it) } ?: imagenSinFoto
    }
    val diasDeLaSemana = arrayOf("L", "M", "X", "J", "V", "S", "D")

    Surface(
        modifier = Modifier.fillMaxSize()

    ) {

        Column {


            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 15.dp)
            )
            {
                Text(
                    text = verRutinaState.titulo,
                    color = Color(0xFFDAB338),
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Button(
                        modifier = Modifier.padding(10.dp),
                        onClick = { onNavigateToPrevious() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor
                            = Color(0xFFC29F6C)
                        )
                    ) {
                        Text("VOLVER")
                    }
                    when (verRutinaState.estado) {
                        "UnAdded" -> {
                            Button(
                                modifier = Modifier.padding(10.dp),
                                onClick = {
                                    onVerRutinaEvent(
                                        VerRutinaEvent.onAddRutina(
                                            onNavigateToRutinas
                                        )
                                    )
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor
                                    = Color(0xFF89602F)
                                )
                            ) {
                                Text("AÑADIR")
                            }
                        }

                        "current" -> {
                            Button(
                                modifier = Modifier.padding(10.dp),
                                onClick = {
                                    onVerRutinaEvent(
                                        VerRutinaEvent.onDesactivarClicked(
                                            onNavigateToRutinas
                                        )
                                    )
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor
                                    = Color(0xFF89602F)
                                )
                            ) {
                                Text("DESACTIVAR")
                            }
                        }

                        else -> {
                            Button(
                                modifier = Modifier.padding(10.dp),
                                onClick = {
                                    onVerRutinaEvent(
                                        VerRutinaEvent.onActivarClicked(
                                            onNavigateToRutinas
                                        )
                                    )
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor
                                    = Color(0xFF89602F)
                                )
                            ) {
                                Text("ACTIVAR")
                            }
                        }
                    }
                }
                Box(modifier = Modifier.clickable { if (mostrarSnack) onMostrarSnackbar() }) {

                    LaunchedEffect(mostrarSnack) {
                        if (mostrarSnack) {
                            delay(3000L)
                            onMostrarSnackbar()
                        }
                    }
                    if (mostrarSnack) {
                        Snackbar(containerColor = Color(0xFF89602F)) {
                            Text(text = "Ya tienes esta rutina en tu lista")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row( //Las bolas de los dias de la semana
                    Modifier
                        .height(55.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(diasDeLaSemana.size) { iteration ->
                        val colorDeFondo =
                            if (diasDeLaSemana[iteration] == diaSeleccionado) Color(0xFFDAB338) else Color(
                                0xFFDCCEA2
                            )

                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(CircleShape)
                                .background(colorDeFondo)
                                .size(30.dp)
                                .clickable {
                                    onVerRutinaEvent(VerRutinaEvent.onCambiarDia(diasDeLaSemana[iteration]))
                                },
                            contentAlignment = Alignment.Center,
                        )
                        {
                            Text(
                                text = diasDeLaSemana[iteration],
                                color = Color.White,
                                fontSize = 15.sp,
                                fontFamily = FontFamily(
                                    Font(resId = R.font.bayon_regular)
                                )
                            )
                        }
                    }
                }
            }
            if (verRutinaState.ejercicio.isNotEmpty()) {
                val musculos = verRutinaState.ejercicio.map { it.musculo }.distinct()
                val musculosText = musculos.joinToString(" - ")


                Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp))
                {
                    if (musculosText.isBlank()) {
                        Text(
                            text = "Selecciona un día para ver tus ejercicios",
                            fontSize = 20.sp,
                            color = Color(0xFFDAB338),
                            fontFamily = FontFamily(Font(resId = R.font.bayon_regular))
                        )
                    }
                    Text(
                        text = musculosText,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Start,
                        color = Color(0xFFDAB338),
                        fontFamily = FontFamily(
                            Font(resId = R.font.bayon_regular)
                        )
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color(0xFFDAB338)
                    )
                    Box(modifier = Modifier.fillMaxSize())
                    {
                        LazyColumn(
                            contentPadding = PaddingValues(5.dp),
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            items(verRutinaState.ejercicio) { ejercicio ->
                                Row(Modifier.clickable {
                                    onVerRutinaEvent(VerRutinaEvent.onClickEjercicio(ejercicio))
                                })
                                {
                                    Box(modifier = Modifier.width(300.dp))
                                    {
                                        Text(
                                            modifier = Modifier.padding(bottom = 10.dp),
                                            text = ejercicio.nombre,
                                            fontSize = 25.sp,
                                            fontFamily = FontFamily(
                                                Font(resId = R.font.roboto_bolditalic)
                                            ),
                                            color = Color(0xFFDAB338)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Icon(
                                            Icons.AutoMirrored.Filled.ArrowForwardIos,
                                            contentDescription = "Visibility",
                                            modifier = Modifier.padding(bottom = 14.dp),
                                            tint = Color(0xFFDCCEA2)
                                        )

                                    }

                                }
                                HorizontalDivider(
                                    modifier = Modifier.padding(bottom = 10.dp),
                                    thickness = 1.dp,
                                    color = Color(0xFFDAB338)
                                )
                            }
                        }
                    }

                }
            } else {
                DescansoScreen()
            }


        }
        if (mostrarDialog) {
            AlertDialog(
                onDismissRequest = { onMostrarDialog(false) },
                title = {
                    Text(
                        text = maquinaUiState.nombre, color = Color(0xFFDAB338), fontSize = 28.sp,
                        fontFamily = FontFamily(
                            Font(resId = R.font.roboto_bolditalic)
                        ),
                    )
                },
                text = {
                    Column {
                        Image(
                            modifier = Modifier.size(350.dp),
                            painter = painterFoto,
                            contentDescription = "Imagen ejercicio"
                        )
                        Text(
                            maquinaUiState.descripcion, color = Color(0xFFDAB338), fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(resId = R.font.roboto_mediumitalic)
                            ),
                        )
                    }
                },
                confirmButton = {
                    Button(onClick = { onMostrarDialog(false) }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
