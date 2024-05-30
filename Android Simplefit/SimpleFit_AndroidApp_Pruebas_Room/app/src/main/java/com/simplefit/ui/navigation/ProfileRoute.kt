package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.mainApp.perfil.ProfileScreen
import com.simplefit.ui.features.mainApp.perfil.ProfileViewModel

const val ProfileRoute = "Profile"


fun NavGraphBuilder.profileScreen(
    profileViewModel: ProfileViewModel,
    onNavigateToLogin: () -> Unit
) {
    composable(
        route = ProfileRoute
    ) {

        ProfileScreen(
            onNavigateToLogin  = onNavigateToLogin,
            profileUiState = profileViewModel.profileUiState,
            onProfileEvent = profileViewModel::onProfileEvent,
            validacionProfileUiState = profileViewModel.validacionProfileUiState,
            onMostrarSnackBar = profileViewModel.onMostrarSnackBar,
            mostrarSnack = profileViewModel.mostrarSnackBar,
        )
    }
}
fun NavController.navigateToProfile(navOptions: NavOptions? = null){
    this.navigate(ProfileRoute, navOptions)
}