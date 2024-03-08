package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.mainApp.profile.ProfileScreen
import com.simplefit.ui.features.mainApp.routines.RoutinesScreen
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel

const val RoutinesRoute = "Routines"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.routinesScreen(
    routinesViewModel: RoutinesViewModel,
) {
    composable(route = RoutinesRoute) {
        RoutinesScreen()

    }

}

fun NavController.navigateToRoutines(navOptions: NavOptions? = null) {
    val ruta = RoutinesRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate(ruta, navOptions)
}
