package com.simplefit.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos

import androidx.compose.material.icons.filled.Face2
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.R
import com.simplefit.ui.features.mainApp.rutinas.RutinasUiState

@Composable
fun DatosRutina(
    modifier: Modifier = Modifier,
    titulo: String,
    frecuencia: Int,
    diasDescanso: Int,
    dificultad: String,
    estado : String,
    seleccionadoState: Boolean,
    onVerRutinaClicked: () -> Unit? = {}
) {
    Row()
    {


        Column(
            modifier = modifier.then(
                Modifier.fillMaxWidth(0.50f)
            ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        )
        {
            Text(
                modifier = modifier.padding(top = 7.dp),
                text = titulo,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontStyle = FontStyle.Normal
            )
            Row()
            {
                Text(
                    text = if (titulo.isNotBlank()) "$dificultad | " else "",
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF89602F),
                    fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                    fontStyle = FontStyle.Normal
                )


                Text(
                    text = "Frecuencia $frecuencia" + if (titulo.isBlank()) " | Desc: $diasDescanso Dias | $dificultad" else "",
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF89602F),
                    fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                    fontStyle = FontStyle.Normal,

                    )
            }
            if (estado == "current") {
                Text(
                    text = "ACTIVA",
                    color = Color(0xFF89602F),
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                    modifier = Modifier

                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth(0.25f).fillMaxHeight())
                    {
                        if (seleccionadoState) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowForwardIos,
                                contentDescription = "Flecha Derecha",
                                tint = Color.White,
                                modifier = Modifier.align(Alignment.Center)
                                    //.padding(top = 28.dp, start = 25.dp)
                                    .clickable {
                                        onVerRutinaClicked()
                                    })
                        }
                    }
    }


}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContenidoPrincipalCardRutina(
    rutinaUiState: RutinasUiState,
    seleccionadoState: Boolean,
    modifier: Modifier = Modifier,
    onVerRutinaClicked: () -> Unit? = {}
) {
    Box(
        Modifier
            .height(90.dp)
            .fillMaxWidth()
            .background(
                color = if (seleccionadoState) Color(0xFFDAB338) else Color(0xFFDCCEA2),
                shape = RoundedCornerShape(
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                    topStart = 10.dp
                )
            )
    )
    {
        Row(
            modifier = modifier.then(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(5.dp)
            ),
            //verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.Center
            ) {
                if (rutinaUiState.descripcion.isNotBlank()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.25f)
                            //.size(80.dp, 80.dp)
                            //.size(0.25f)
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        val imageResource = when (rutinaUiState.dificultad) {
                            "Intermedia" -> R.drawable.hipertrofia
                            "Avanzada" -> R.drawable.definicion
                            "Principiante" -> R.drawable.mantenimiento
                            else -> R.drawable.hipertrofia
                        }
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
                            painter = painterResource(id = imageResource),
                            contentDescription = "Imagen objetivo"
                        )
                    }
                }
                DatosRutina(
                    modifier = Modifier,
                    titulo = rutinaUiState.titulo,
                    frecuencia = rutinaUiState.frecuencia,
                    diasDescanso = rutinaUiState.diasDescanso,
                    dificultad = rutinaUiState.dificultad,
                    estado = rutinaUiState.estado,
                    seleccionadoState = seleccionadoState,
                    onVerRutinaClicked = onVerRutinaClicked

                )

//                    Box(modifier = Modifier.size(70.dp))
//                    {
//                        if (seleccionadoState) {
//                            Icon(
//                                Icons.AutoMirrored.Filled.ArrowForwardIos,
//                                contentDescription = "Flecha Derecha",
//                                tint = Color.White,
//                                modifier = Modifier
//                                    //.padding(top = 28.dp, start = 25.dp)
//                                    .clickable {
//                                        onVerRutinaClicked()
//                                    })
//                        }
//                    }



            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RutinasListItem2(
    onVerRutinaClicked: () -> Unit? = {},
    modifier: Modifier = Modifier,
    rutinaUiState: RutinasUiState,
    seleccionadoState: Boolean,
    onRutinaClicked: (Int) -> Unit
) {


    ElevatedCard(
        onClick = { onRutinaClicked(rutinaUiState.rutinaid) },
        modifier = modifier.then(
            Modifier
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .padding(6.dp)
        ),
    ) {

        val context = LocalContext.current

        Row {
            ContenidoPrincipalCardRutina(
                rutinaUiState = rutinaUiState,
                seleccionadoState = seleccionadoState,
                onVerRutinaClicked = onVerRutinaClicked
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RutinasListItem(
    onVerRutinaClicked: () -> Unit,
    modifier: Modifier = Modifier,
    rutinaUiState: RutinasUiState,
    seleccionadoState: Boolean,
    onRutinaClicked: (Int) -> Unit,
) {
    ElevatedCard(
        onClick = { onRutinaClicked(rutinaUiState.rutinaid) },
        modifier = modifier.then(
            Modifier
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .padding(6.dp)
        ),
    ) {


            ContenidoPrincipalCardRutina(
                rutinaUiState = rutinaUiState,
                seleccionadoState = seleccionadoState,
                onVerRutinaClicked = onVerRutinaClicked
            )

        }

}




@Composable
fun ImagenRutina(
    modifier: Modifier = Modifier,
    foto: ImageBitmap?,
    anchoBorde: Dp = 4.dp,
) {
    val imagenSinFoto = rememberVectorPainter(image = Icons.Filled.Face2)
    var painterFoto = remember(foto) {
        foto?.let { BitmapPainter(it) } ?: imagenSinFoto
    }
    Image(
        modifier = modifier.then(
            Modifier
                .clip(CircleShape)
                .aspectRatio(ratio = 1f)
                .background(MaterialTheme.colorScheme.surface)
                .border(
                    width = anchoBorde,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    shape = CircleShape
                )
        ),
        painter = painterFoto,
        contentScale = ContentScale.Crop,
        contentDescription = "Imagen rutina objetivo"
    )
}