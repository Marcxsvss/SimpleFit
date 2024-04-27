package com.simplefit.ui.features.mainApp.crearRutina

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.simplefit.ui.composables.ExposedDropdownMenuBoxFrecuencia
import com.simplefit.ui.composables.RutinasListItem
import com.simplefit.ui.composables.RutinasListItem2
import com.simplefit.ui.features.mainApp.routines.RoutinesEvent
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddRutinaScreen(
    rutinasState: List<RoutinesUiState>,
    rutinaSeleccionadaState: RoutinesUiState?,
    //addRutinaState: AddRutinaUiState,
    onAddRutinaEvent: (AddRutinaEvent) -> Unit,
    mostrarDialog: Boolean,
    onMostrarDialog: (Boolean) -> Unit,
) {

    Surface(

        modifier = Modifier.fillMaxSize()

    ) {
        if (mostrarDialog) {
            AlertDialog(
                onDismissRequest = { onMostrarDialog(false) },
                title = {
                    Text(
                        text = "Ordenar por...", color = Color(0xFFDAB338), fontSize = 28.sp,
                        fontFamily = FontFamily(
                            Font(resId = R.font.roboto_bolditalic)
                        ),
                    )
                },
                text = {
                    Column {
                        //Cuando pulse un botón tiene que ponerse con este color Color(0xFF89602F)
                        Button(onClick = { onAddRutinaEvent(AddRutinaEvent.onOrdenarPorFrecuencia) },
                            colors = ButtonDefaults.buttonColors(containerColor
                            = Color(0xFFC29F6C))) {
                            Text("FRECUENCIA")
                        }
                        Button(onClick = { onAddRutinaEvent(AddRutinaEvent.onOrdenarPorDescanso) },
                            colors = ButtonDefaults.buttonColors(containerColor
                            = Color(0xFFC29F6C))) {
                            Text("DÍAS DESCANSO")
                        }
                        Button(onClick = { onAddRutinaEvent(AddRutinaEvent.onOrdenarPorDificultad) },
                            colors = ButtonDefaults.buttonColors(containerColor
                            = Color(0xFFC29F6C))) {
                            Text("DIFICULTAD")
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = { onMostrarDialog(false) },
                        colors = ButtonDefaults.buttonColors(containerColor
                        = Color(0xFFDAB338))
                    ) {
                        Text("Aplicar")
                    }
                }
            )
        }

        Column(
            verticalArrangement = Arrangement.Top,
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
                CloudButton(
                    texto = "TODAS",
                    onTodasClicked = { onAddRutinaEvent(AddRutinaEvent.onTodasClicked) }
                )
                Spacer(modifier = Modifier.width(10.dp))
                CloudButton(
                    texto = "FILTROS",
                    onFiltroClicked = { onAddRutinaEvent(AddRutinaEvent.onFiltroClicked) }
                )
            }
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(
                        rutinasState,
                        key = { it.rutinaid }
                    ) { rutina ->
                        RutinasListItem2(
                            modifier = Modifier.animateItemPlacement(),
                            rutinaUiState = rutina,
                            seleccionadoState = rutinaSeleccionadaState?.let { it.rutinaid == rutina.rutinaid }
                                ?: false,
                            onRutinaClicked = {
                                onAddRutinaEvent(AddRutinaEvent.onRutinaClicked(rutina.rutinaid))
                            },
                            //onUnSelectClicked = {onAddRutinaEvent(AddRutinaEvent.onUnSelectClicked)},
                        )
                    }
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
