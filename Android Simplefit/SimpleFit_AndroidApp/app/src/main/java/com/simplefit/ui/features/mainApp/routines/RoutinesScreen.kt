package com.simplefit.ui.features.mainApp.routines

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.R
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.LaunchedEffect
import com.simplefit.ui.composables.RutinasListItem
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RoutinesScreen(
    rutinasState: List<RoutinesUiState>,
    rutinaSeleccionadaState: RoutinesUiState?,
    onRutinaEvent: (RoutinesEvent) -> Unit,
    onNavigateToVerRutina: ((rutina: RoutinesUiState) -> Unit)? = null,
    onNavigateToAddRutina: ((userid: String) -> Unit)? = null,
    mostrarSnack: Boolean,
    onMostrarSnackbar: () -> Unit
) {

    Surface(
        modifier = Modifier.fillMaxSize()

    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {


            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            )
            {

                Text(
                    text = "RUTINAS",
                    color = Color(0xFFDAB338),
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic
                )
                IconButton(onClick = {
                    onRutinaEvent(
                        RoutinesEvent.onAddClicked(
                            onNavigateToAddRutina
                        )
                    )
                }, modifier = Modifier.padding(start = 70.dp)) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Añadir Plan de Entrenamiento/Alimenticio",
                    )
                }

            }


            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Row(modifier = Modifier
                .align(Alignment.End)
                .height(40.dp)) {
                LaunchedEffect(mostrarSnack) {
                    if (mostrarSnack) {
                        delay(3000L)
                        onMostrarSnackbar()
                    }
                }

                if (mostrarSnack) {
                    Snackbar( modifier = Modifier.width(250.dp)
                    ) {
                        Text(text = "No puedes eliminar una rutina activa",fontSize = 13.sp)
                    }
                }
                if (rutinaSeleccionadaState!!.descripcion.isNotBlank()) {

                    IconButton(onClick = { onRutinaEvent(RoutinesEvent.onDeleteClicked) })
                    {
                        Icon(
                            tint = Color(0xFFDAB338),
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Eliminar Rutina",
                        )
                    }
                    IconButton(onClick = { onRutinaEvent(RoutinesEvent.onCancelClicked) })
                    {
                        Icon(
                            tint = Color(0xFFDAB338),
                            imageVector = Icons.Filled.Cancel,
                            contentDescription = "Cancelar"
                        )
                    }
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {

                LazyColumn(
                    contentPadding = PaddingValues(all = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(
                        rutinasState,
                        key = { it.rutinaid }
                    ) { rutina ->
                        RutinasListItem(
                            onVerRutinaClicked = {
                                onRutinaEvent(
                                    RoutinesEvent.onVerClicked(
                                        onNavigateToVerRutina
                                    )
                                )
                            },
                            modifier = Modifier.animateItemPlacement(),
                            rutinaUiState = rutina,
                            seleccionadoState = rutinaSeleccionadaState?.let { it.rutinaid == rutina.rutinaid }
                                ?: false,
                            onRutinaClicked = {
                                onRutinaEvent(
                                    RoutinesEvent.onRutinaClicked(
                                        rutina.rutinaid
                                    )
                                )
                            }
                        )
                    }
                }

            }
        }

    }
}
