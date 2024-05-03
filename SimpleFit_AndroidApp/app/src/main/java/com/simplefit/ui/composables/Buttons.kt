package com.simplefit.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.R
import com.simplefit.ui.features.mainApp.crearRutina.AddRutinaEvent
import com.simplefit.ui.features.mainApp.home.HomeEvent
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState

@Composable
fun CloudButton(texto : String,onTodasClicked: () -> Unit? = {},onFiltroClicked: () -> Unit? = {})
{
    Button(
        onClick = {if(texto == "TODAS") onTodasClicked() else onFiltroClicked()},
        colors = ButtonColors(
            containerColor = Color(0xFFDBC06D),
            contentColor = Color.White,
            disabledContainerColor =  Color.White,
            disabledContentColor = Color.White
        ),

    )
    {
        Text(
            text = texto,
            color = Color.White,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
            fontStyle = FontStyle.Normal
        )
        if(texto == "FILTROS")
            Icon(Icons.Filled.FilterList, contentDescription = "Filtro",modifier = Modifier.padding(start=8.dp))
    }

}
@Composable
fun HomeButton(texto : String,foto : Painter, onHomeEvent: (HomeEvent) -> Unit, dia : String = "",onNavigateToVerEntrenamiento:((rutina: RoutinesUiState) -> Unit)? = null)
{
    Box( //Ver entrenamiento de hoy
        Modifier
            .width(358.dp)
            .height(100.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Transparent),
                    startY = 0.0f,
                    endY = Float.POSITIVE_INFINITY
                ),
                shape = RoundedCornerShape(
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                    topStart = 10.dp
                )
            )
            .clickable {
                when (texto) {
                    "VER ENTRENAMIENTO" -> { onHomeEvent(HomeEvent.onVerEntrenamientoClicked(onNavigateToVerEntrenamiento)) }
                    "CONSEJOS" -> {
                        //onHomeEvent(HomeEvent.)
                    }
                    else -> {
                        //onHomeEvent(HomeEvent.)
                    }
                }
            }
    ) {
        Image(
            painter = foto,
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Row(modifier = Modifier.align(Alignment.Center)) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = texto,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal
            )
        }
    }
}
@Preview
@Composable
fun CloudButtonPreview()
{
    CloudButton("TODAS")
}