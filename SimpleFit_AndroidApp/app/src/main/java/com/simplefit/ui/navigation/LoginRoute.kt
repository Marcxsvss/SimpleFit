package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.simplefit.ui.features.login.LoginScreen
import com.simplefit.ui.features.login.LoginViewModel

const val LoginRoute="login"
fun NavGraphBuilder.loginScreen(
    loginViewModel: LoginViewModel,
    onNavigateToRecetas:(correo:String)->Unit
) {

    composable(LoginRoute){
        LoginScreen(
            usuarioUiState = loginViewModel.usuarioUiState,
            validacionLoginUiState = loginViewModel.validacionLoginUiState,
            mostrarSnack = loginViewModel.mostrarSnackBar ,
            onLoginEvent = loginViewModel::onLoginEvent,
            onMostrarSnackBar =loginViewModel.onMostrarSnackBar,
            onNavigateToRecetas = onNavigateToRecetas)
    }


    fun NavController.navigateToLogin() {
        this.navigate(LoginRoute)
    }

}