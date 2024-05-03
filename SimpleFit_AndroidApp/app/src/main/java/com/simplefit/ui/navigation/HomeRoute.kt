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
import com.simplefit.ui.features.mainApp.home.HomeViewModel
import com.simplefit.ui.features.mainApp.profile.ProfileViewModel
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState


const val HomeRoute = "Home"
const val HomeParameterName = "email"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.homeScreen(
    homeViewModel: HomeViewModel,
    mainAppViewModel: MainAppViewModel,
    onNavigateToVerEntrenamiento:((rutina: RoutinesUiState) -> Unit),

    ) {
    composable(
        route = "$HomeRoute/{$HomeParameterName}",
        arguments = listOf(
            navArgument(HomeParameterName) {
                type = NavType.StringType
            }
        )
    ) {
    backStackEntry ->
       val email :String? = backStackEntry.arguments?.getString(HomeParameterName, "Email erroneo")
        mainAppViewModel.setUsuario(email ?: "Email erroneo")

        HomeScreen(
            homeUiState = homeViewModel.homeUiState,
            onHomeEvent = homeViewModel::onHomeEvent,
            onNavigateToVerEntrenamiento = onNavigateToVerEntrenamiento)
    }
    composable(HomeRoute)
    {
        HomeScreen(
            homeUiState = homeViewModel.homeUiState,
            onHomeEvent = homeViewModel::onHomeEvent,
            onNavigateToVerEntrenamiento = onNavigateToVerEntrenamiento)

    }
}
fun NavController.navigateToHome(email: String,navOptions: NavOptions? = null){
    val ruta = HomeRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$email", navOptions)
}
fun NavController.navigateToHome2(navOptions: NavOptions? = null){
    this.navigate(HomeRoute, navOptions)
}
