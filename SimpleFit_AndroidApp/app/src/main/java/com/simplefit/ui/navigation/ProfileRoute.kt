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
import com.simplefit.ui.features.mainApp.profile.ProfileScreen
import com.simplefit.ui.features.mainApp.profile.ProfileViewModel

const val ProfileRoute = "Profile"


// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.profileScreen(
    profileViewModel : ProfileViewModel
) {
    composable(
        route = ProfileRoute
    ) {
        ProfileScreen()
    }
}
fun NavController.navigateToProfile(navOptions: NavOptions? = null){
    val ruta = ProfileRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate(ruta, navOptions)
}