package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.mainApp.MainAppViewModel
import com.simplefit.ui.features.mainApp.profile.ProfileViewModel
import com.simplefit.ui.features.mainApp.routines.RoutinesEvent.onRutinaClicked
import com.simplefit.ui.features.mainApp.routines.RoutinesScreen
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel

const val RoutinesRoute = "Routines"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.routinesScreen(
    routinesViewModel: RoutinesViewModel,
    onNavigateToVerRutina:((rutina: RoutinesUiState) -> Unit)? = null

) {
    composable(route = RoutinesRoute) {
        RoutinesScreen( rutinasState = routinesViewModel.routinesList,
            rutinaSeleccionadaState = routinesViewModel.routinesUiState,
            onRutinaEvent = routinesViewModel::onRoutinesEvent,
            onNavigateToVerRutina = onNavigateToVerRutina
        )


    }

}

fun NavController.navigateToRoutines(navOptions: NavOptions? = null) {

    this.navigate(RoutinesRoute, navOptions)
}
