package com.simplefit.ui.composables

import android.Manifest
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactoListItem(
    modifier: Modifier = Modifier,
    contactoUiState: RoutinesUiState,
    seleccionadoState: Boolean,
    onContactoClicked: (RoutinesUiState) -> Unit,
    onEditClicked: () -> Unit,
    onDeleteClicked: () -> Unit
) = ElevatedCard(
    onClick = { onContactoClicked(contactoUiState) },
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
            contactoUiState = contactoUiState,
            seleccionadoState = seleccionadoState
        )
        if (seleccionadoState)
            AccionesRutina(
                onEditClicked = onEditClicked,
                onDeleteClicked = onDeleteClicked,
                onCorreoClicked = { context.enviarMail(correo = contactoUiState.correo) }
            )
    }
}