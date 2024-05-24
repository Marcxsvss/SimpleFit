package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.mainApp.routines.RoutinesScreen
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel

const val RoutinesRoute = "Routines"

fun NavGraphBuilder.routinesScreen(
    routinesViewModel: RoutinesViewModel,
    onNavigateToVerRutina: ((rutina: RoutinesUiState) -> Unit)? = null,
    onNavigateUp : () -> Unit
) {
    composable(route = RoutinesRoute) {
        RoutinesScreen(
            rutinasState = routinesViewModel.routinesList,
            rutinaSeleccionadaState = routinesViewModel.routinesUiState,
            onRutinaEvent = routinesViewModel::onRoutinesEvent,
            onNavigateToVerRutina = onNavigateToVerRutina,
            busquedaState = routinesViewModel.busquedaState,
            onNavigateUp = onNavigateUp
        )
    }
}

fun NavController.navigateToRoutines(navOptions: NavOptions? = null) {
    this.navigate(RoutinesRoute, navOptions)
}

