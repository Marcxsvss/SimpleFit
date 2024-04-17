package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.simplefit.ui.features.userAuthentication.login.LoginScreen
import com.simplefit.ui.features.userAuthentication.login.LoginViewModel

const val LoginRoute="login"
fun NavGraphBuilder.loginScreen(
    loginViewModel: LoginViewModel,
    onNavigateToHome:((correo: String) -> Unit)? = null,
    onNavigateToRegister:()->Unit
) {

    composable(LoginRoute){
        LoginScreen(
            usuarioUiState = loginViewModel.usuarioUiState,
            validacionLoginUiState = loginViewModel.validacionLoginUiState,
            mostrarSnack = loginViewModel.mostrarSnackBar ,
            onLoginEvent = loginViewModel::onLoginEvent,
            onMostrarSnackBar =loginViewModel.onMostrarSnackBar,
            onNavigateToHome = onNavigateToHome,
            onNavigateToRegister = onNavigateToRegister)
    }
}
fun NavController.navigateToLogin() {
    this.navigate(LoginRoute)
}