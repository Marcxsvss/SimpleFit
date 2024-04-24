package com.simplefit.ui.features.mainApp.crearRutina

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.R
import com.simplefit.models.Rutinas
import com.simplefit.ui.composables.CloudButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddRutinaScreen(
    addRutinaState: AddRutinaUiState,
    onAddRutinaEvent: (AddRutinaEvent) -> Unit,
) {

    Surface(

        modifier = Modifier.fillMaxSize()

    ) {
        Column(
            verticalArrangement =  Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "AÑADIR RUTINA",
                color = Color(0xFFDAB338),
                fontSize = 30.sp,
                fontFamily = FontFamily(
                    Font(resId = R.font.roboto_blackitalic)
                )
            )
            Row()
            {
                CloudButton(texto = "TODAS")
                Spacer( modifier = Modifier.width(10.dp))
                CloudButton(texto = "RECOMENDADAS")
                IconButton(onClick = {  }) {
                    Icon(Icons.Filled.FilterList, contentDescription = "Filtro")
                }
            }



        }


    }
}
@Preview
@Composable
fun CrearRutinaPreview() {
    //CrearRutinaScreen()
}
