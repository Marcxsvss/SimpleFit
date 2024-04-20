package com.simplefit.ui.features.mainApp.verRutina

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.simplefit.R
import com.simplefit.ui.composables.RutinasListItem
import java.util.Calendar

fun obtenerDiaDeLaSemana(): String {
    val dias = arrayOf("D", "L", "M", "X", "J", "V", "S")
    val calendario = Calendar.getInstance()
    val diaDeLaSemana = calendario.get(Calendar.DAY_OF_WEEK)
    return dias[diaDeLaSemana - 1]
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerRoutinesScreen(
    verRutinaState: VerRutinaUiState,
    //verRutinaSeleccionado : VerRutinaUiState?,
    onVerRutinaEvent: (VerRutinaEvent) -> Unit,
    ) {


    val diasDeLaSemana = arrayOf("L", "M", "X", "J", "V", "S", "D")
    val diaActual = obtenerDiaDeLaSemana()

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
                Spacer(modifier = Modifier.height(15.dp))
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
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }
            if (verRutinaState.descripcion != "Descanso") {
                val musculo = verRutinaState.ejercicio[0].musculo
                val musculo2 = verRutinaState.ejercicio.firstOrNull { it.musculo != musculo }

                Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp))
                {
                    Text(
                        text = "$musculo - $musculo2",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Start,
                        color = Color(0xFFDAB338)
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
                                Text(text = ejercicio.nombre)
                            }
                        }
                    }

                }
            } else {
                Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp))
                {
                    Text(
                        text = "Descanso",
                        fontSize = 30.sp,
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
                    Text(
                        text = "No hay ejercicios para hoy, asegúrate dormir y comer de forma saludable para la correcta recuperacion de tus músculos¡¡",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        color = Color(0xFFDAB338),
                        fontFamily = FontFamily(
                            Font(resId = R.font.roboto_blackitalic)
                        )

                    )
                    Image(
                        modifier = Modifier
                            .clip(CircleShape)
                            .aspectRatio(ratio = 1f)
                            .background(Color.White)
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = CircleShape
                            ),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.recuperacion),
                        contentDescription = "Imagen objetivo"
                    )
                }
            }

        }
    }
}
