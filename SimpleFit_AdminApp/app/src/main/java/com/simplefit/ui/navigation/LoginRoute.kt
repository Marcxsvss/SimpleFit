package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.userAuthentication.login.LoginScreen
import com.simplefit.ui.features.userAuthentication.login.LoginViewModel

const val LoginRoute="login"
fun NavGraphBuilder.loginScreen(
    loginViewModel: LoginViewModel,
    onNavigateToHome:((correo: String) -> Unit)? = null
) {

    composable(LoginRoute){
        LoginScreen(
            usuarioUiState = loginViewModel.usuarioUiState,
            validacionLoginUiState = loginViewModel.validacionLoginUiState,
            mostrarSnack = loginViewModel.mostrarSnackBar ,
            onLoginEvent = loginViewModel::onLoginEvent,
            onMostrarSnackBar =loginViewModel.onMostrarSnackBar,
            onNavigateToHome = onNavigateToHome)
    }
}
fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.popBackStack()
    this.navigate(LoginRoute,navOptions)
}

