package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.mainApp.home.HomeScreen
import com.simplefit.ui.features.mainApp.home.HomeViewModel


const val HomeRoute = "Home"
const val HomeParameterName = "email"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.homeScreen(
    homeViewModel : HomeViewModel,
    onNavigateToLogin: () -> Unit,
) {
    composable(
        route = "$ProfileRoute/{$HomeParameterName}",
        arguments = listOf(
            navArgument(HomeParameterName) {
                type = NavType.StringType
            }
        )
    ) {
    backStackEntry ->
       val email :String? = backStackEntry.arguments?.getString(HomeParameterName, "Email erroneo")
        homeViewModel.setUsuario(email ?: "Email erroneo")

        HomeScreen(
            homeUiState = homeViewModel.homeUiState,
            onHomeEvent = homeViewModel::onHomeEvent,
            onNavigateToLogin = onNavigateToLogin,
            indexState = homeViewModel.indexState

        )
    }
}
fun NavController.navigateToHome(email: String,navOptions: NavOptions? = null){
    val ruta = ProfileRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$email", navOptions)
}
fun NavController.navigateToHome(navOptions: NavOptions? = null){
    val ruta = ProfileRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate(ruta, navOptions)
}
