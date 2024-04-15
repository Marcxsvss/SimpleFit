package com.simplefit.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
@Composable
fun DatosRutina(
    modifier: Modifier = Modifier,
    titulo: String,
    descripcion: String,
    objetivo: String,
    frecuencia: Int
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "${titulo}",
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = objetivo,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.secondary
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = frecuencia.toString(),
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.width(8.dp))
            //Categorias(categorias)
        }
    }
}
@OptIn(ExperimentalLayoutApi::class)
// Muestra la imagen del contacto, los datos del contacto y un perqueño
// icono que tendrá una animación de rotación cuando el contacto esté
// seleccionado.
@Composable
fun ContenidoPrincipalCardRutina(
    rutinaUiState: RoutinesUiState,
    seleccionadoState: Boolean,
    modifier: Modifier = Modifier
) {
    // Estado de la rotación del icono de la flecha dependiendo
    // de si el item está seleccionado o no.
    val rotacionIconoDropDown by animateFloatAsState(
        targetValue = if (seleccionadoState) 180f else 0f, label = ""
    )

    Row(
        modifier = modifier.then(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Usa FlowRow para que la imagen se superponga a los datos
        // de contacto cuando no haya suficiente espacio para ambos
        FlowRow(
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
            }
            DatosRutina(
                modifier = Modifier,
                titulo = rutinaUiState.titulo,
                descripcion = rutinaUiState.descripcion,
                objetivo = rutinaUiState.objetivo,
                frecuencia = rutinaUiState.frecuencia,
            )
        }
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = "Seleccionado",
            // El valor viene establecido por un estado que se animará
            // cuando el item esté seleccionado o no.
            modifier = modifier.rotate(rotacionIconoDropDown)
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RutinasListItem(
    modifier: Modifier = Modifier,
    rutinaUiState: RoutinesUiState,
    seleccionadoState: Boolean,
    onRutinaClicked: (Int) -> Unit,
    onEditClicked: () -> Unit,
    onDeleteClicked: (Int) -> Unit
) = ElevatedCard(
    onClick = { onRutinaClicked(rutinaUiState.rutinaid) },
    modifier = modifier.then(
        Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
    )
) {

    val context = LocalContext.current

    Column {
        ContenidoPrincipalCardRutina(
            rutinaUiState = rutinaUiState,
            seleccionadoState = seleccionadoState
        )
        if (seleccionadoState)
            AccionesRutina(
                onEditClicked = onEditClicked,
                onDeleteClicked = onDeleteClicked,
                onCompartirClicked = {  }
            )
    }
}
@Preview(
    name = "PORTRAIT",
    device = "spec:width=360dp,height=800dp,dpi=480",
    showBackground = true
)
// Muestra OutlinedIconButton con los iconos de las
// acciones posibles sobre ul contacto seleccionado.
@Composable
fun AccionesRutina(
    onCompartirClicked: () -> Unit = {},
    onEditClicked: () -> Unit = {},
    onDeleteClicked: (Int) -> Unit = {}
) {
    data class Accion(
        val icon: ImageVector,
        val description: String,
        val onClick: (() -> Unit)? = null,
        val onClickDelete: ((Int) -> Unit)? = null
    )

    val acciones = remember {
        listOf(
            Accion(
                icon = Icons.Filled.Share,
                description = "Compartir",
                onClick = onCompartirClicked
            ),
            Accion(
                icon = Icons.Filled.Edit,
                description = "Editar",
                onClick = onEditClicked
            ),
            Accion(
                icon = Icons.Filled.Delete,
                description = "Eliminar",
                onClickDelete = onDeleteClicked
            )
        )
    }

    Row(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .animateContentSize { initialValue, targetValue -> },
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        for (accion in acciones) {
            accion.onClick?.let {
                OutlinedIconButton(
                    modifier = Modifier.padding(start = 8.dp),
                    onClick = it,
                ) {
                    Icon(
                        imageVector = accion.icon,
                        contentDescription = accion.description,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(70.dp))
    }
}