package com.simplefit.ui.features.mainApp.verRutina

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.draw.clip
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
fun RoutinesScreen(
    verRutinaState: VerRutinaUiState,
    onVerRutinaEvent: (VerRutinaEvent) -> Unit,

    ) {


    val diasDeLaSemana = arrayOf("L", "M", "X", "J", "V", "S", "D")
    val diaActual = com.simplefit.ui.features.mainApp.home.obtenerDiaDeLaSemana()

    Surface(
        modifier = Modifier.fillMaxSize()

    ) {
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
        }
    }
}