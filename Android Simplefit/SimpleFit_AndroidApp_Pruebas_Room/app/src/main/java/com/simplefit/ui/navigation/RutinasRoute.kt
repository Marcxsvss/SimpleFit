package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.mainApp.rutinas.RutinasScreen
import com.simplefit.ui.features.mainApp.rutinas.RutinasUiState
import com.simplefit.ui.features.mainApp.rutinas.RutinasViewModel

const val RoutinesRoute = "Routines"

fun NavGraphBuilder.rutinasScreen(
    routinesViewModel: RutinasViewModel,
    onNavigateToVerRutina:((rutina: RutinasUiState) -> Unit)? = null,
    onNavigateToAddRutina: ((userid: String) -> Unit)? = null

) {

    composable(route = RoutinesRoute) {


        RutinasScreen( rutinasState = routinesViewModel.routinesList,
            rutinaSeleccionadaState = routinesViewModel.routinesUiState,
            onRutinaEvent = routinesViewModel::onRoutinesEvent,
            onNavigateToVerRutina = onNavigateToVerRutina,
            onNavigateToAddRutina = onNavigateToAddRutina,
            mostrarSnack = routinesViewModel.mostrarSnackBar,
            onMostrarSnackbar = routinesViewModel.onMostrarSnackBar
        )
    }

}

fun NavController.navigateToRoutines(navOptions: NavOptions? = null) {
    this.navigate(RoutinesRoute, navOptions)
}

