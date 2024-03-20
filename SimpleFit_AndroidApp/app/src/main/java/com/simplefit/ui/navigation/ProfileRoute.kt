package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.mainApp.MainAppViewModel
import com.simplefit.ui.features.mainApp.profile.ProfileScreen
import com.simplefit.ui.features.mainApp.profile.ProfileViewModel

const val ProfileRoute = "Profile"


// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.profileScreen(
    profileViewModel: ProfileViewModel,
    mainAppViewModel: MainAppViewModel
) {
    composable(
        route = ProfileRoute
    ) {
        ProfileScreen()
    }
}
fun NavController.navigateToProfile(navOptions: NavOptions? = null){
    this.navigate(ProfileRoute, navOptions)
}