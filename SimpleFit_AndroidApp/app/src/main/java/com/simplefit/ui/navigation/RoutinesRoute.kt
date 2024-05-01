package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.mainApp.MainAppViewModel
import com.simplefit.ui.features.mainApp.home.HomeScreen
import com.simplefit.ui.features.mainApp.profile.ProfileViewModel
import com.simplefit.ui.features.mainApp.routines.RoutinesEvent.onRutinaClicked
import com.simplefit.ui.features.mainApp.routines.RoutinesScreen
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel

const val RoutinesRoute = "Routines"
const val RoutinesParameterName = "userid"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.routinesScreen(
    routinesViewModel: RoutinesViewModel,
    onNavigateToVerRutina:((rutina: RoutinesUiState) -> Unit)? = null,
    onNavigateToAddRutina: ((userid: String) -> Unit)? = null

) {
    composable(route = RoutinesRoute) {
        RoutinesScreen( rutinasState = routinesViewModel.routinesList,
            rutinaSeleccionadaState = routinesViewModel.routinesUiState,
            onRutinaEvent = routinesViewModel::onRoutinesEvent,
            onNavigateToVerRutina = onNavigateToVerRutina,
            onNavigateToAddRutina = onNavigateToAddRutina
        )


    }
    composable(
        route = "$RoutinesRoute/{$RoutinesParameterName}",
        arguments = listOf(
            navArgument(RoutinesParameterName) {
                type = NavType.StringType
            }
        )
    ) {
        RoutinesScreen( rutinasState = routinesViewModel.routinesList,
            rutinaSeleccionadaState = routinesViewModel.routinesUiState,
            onRutinaEvent = routinesViewModel::onRoutinesEvent,
            onNavigateToVerRutina = onNavigateToVerRutina,
            onNavigateToAddRutina = onNavigateToAddRutina
        )

    }


}

fun NavController.navigateToRoutines(navOptions: NavOptions? = null) {
    this.navigate(RoutinesRoute, navOptions)
}
fun NavController.navigateToRoutines2(userid: String, navOptions: NavOptions? = null){
    val ruta = RoutinesRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$userid", navOptions)
}
