package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.mainApp.home.HomeScreen


const val HomeRoute = "Home"
const val HomeParameterName = "email"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.homeScreen(
    onNavigateToUsuarios: () -> Unit,
    onNavigateToConsejos: () -> Unit,
    onNavigateToRutinas: () -> Unit,

    ) {
    composable(
        route = "$HomeRoute/{$HomeParameterName}",
        arguments = listOf(
            navArgument(HomeParameterName) {
                type = NavType.StringType
            }
        )
    ) {
        HomeScreen(
            onNavigateToUsuarios = onNavigateToUsuarios,
            onNavigateToRutinas = onNavigateToRutinas,
            onNavigateToConsejos = onNavigateToConsejos
        )
    }
    composable(HomeRoute)
    {
        HomeScreen(
            onNavigateToUsuarios = onNavigateToUsuarios,
            onNavigateToRutinas = onNavigateToRutinas,
            onNavigateToConsejos = onNavigateToConsejos
        )

    }
}

fun NavController.navigateToHome(email: String, navOptions: NavOptions? = null) {
    val ruta = HomeRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$email", navOptions)
}

fun NavController.navigateToHome2(navOptions: NavOptions? = null) {
    this.navigate(HomeRoute, navOptions)
}
