package com.simplefit.ui.features.mainApp.home

import android.widget.LinearLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.R
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
    onHomeEvent: (HomeEvent) -> Unit

) {
    val diasDeLaSemana = arrayOf("L", "M", "X", "J", "V", "S", "D")
    val diaActual = obtenerDiaDeLaSemana()
Column {
    Box(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                color = Color(0xFFDAB338),
                shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(40.dp)
        ) {
            Text(
                text = "Hola,\n",
                color = Color.White,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal
            )
            Text(
                text = homeUiState.nombre.replaceFirstChar { it.uppercase(Locale.getDefault()) },
                color = Color.White,
                fontSize = 30.sp,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily(Font(R.font.roboto_bold))
            )
        }


    }
    Spacer(modifier = Modifier.height(12.dp))
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row( //Las bolas de los dias de la semana
            Modifier
                .height(55.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(diasDeLaSemana.size) { iteration ->
                val colorDeFondo = if (diasDeLaSemana[iteration] == diaActual) Color(0xFFDAB338) else Color(0xFFDCCEA2)
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(colorDeFondo)
                        .size(30.dp),
                    contentAlignment =  Alignment.Center,
                )
                {
                    Text(text = diasDeLaSemana[iteration], color = Color.White, fontSize = 15.sp)
                }
            }
        }
        Row( // Los cuadraditos
            horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
        )
        {
            Box( //Ver rutina
                Modifier
                    .width(175.dp)
                    .height(100.dp)
                    .background(
                        color = Color(0xFFDBC06D),
                        shape = RoundedCornerShape(
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp,
                            topEnd = 10.dp,
                            topStart = 10.dp
                        )
                    )
            ) {
                Row(modifier = Modifier.align(Alignment.Center)) {
                    Icon(Icons.Filled.FitnessCenter, contentDescription = "Gimnasio")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Rutina",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                        fontStyle = FontStyle.Normal)
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Box( //Ver Dieta
                Modifier
                    .width(175.dp)
                    .height(100.dp)
                    .background(
                        color = Color(0xFFDBC06D),
                        shape = RoundedCornerShape(
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp,
                            topEnd = 10.dp,
                            topStart = 10.dp
                        )
                    )
            ) {
                Row(modifier = Modifier.align(Alignment.Center)) {
                    Icon(Icons.Filled.Restaurant, contentDescription = "Restaurante")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Ver dieta",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                        fontStyle = FontStyle.Normal)
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box( //Frases motivacionales/consejos
            Modifier
                .width(358.dp)
                .height(100.dp)
                .background(
                    color = Color(0xFFDBC06D),
                    shape = RoundedCornerShape(
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp,
                        topStart = 10.dp
                    )
                )
        ) {
            Text(text = "RECOMENDACIONES",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal,
                modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box( //Recomendar a un amigo
            Modifier
                .width(358.dp)
                .height(100.dp)
                .background(
                    color = Color(0xFFDBC06D),
                    shape = RoundedCornerShape(
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp,
                        topStart = 10.dp
                    )
                )
        ) {
            Text(text = "RECOMENDAR AMIGOS",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal,
                modifier = Modifier.align(Alignment.Center))
        }
    }
}


    //0xFFDAB338
}