package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.simplefit.ui.features.login.LoginScreen
import com.simplefit.ui.features.login.LoginViewModel

//const val RegisterProfileInfoRoute="login"
//fun NavGraphBuilder.RegisterProfileInfoScreen(
//    registerProfileInfoViewModel: RegisterProfileInfoViewModel,
//    onNavigateToHome:(correo:String)->Unit
//) {
//
//    composable(RegisterProfileInfoRoute){
//        LoginScreen(
//            usuarioUiState = loginViewModel.usuarioUiState,
//            validacionLoginUiState = loginViewModel.validacionLoginUiState,
//            mostrarSnack = loginViewModel.mostrarSnackBar ,
//            onLoginEvent = loginViewModel::onLoginEvent,
//            onMostrarSnackBar =loginViewModel.onMostrarSnackBar,
//            onNavigateToHome = onNavigateToHome,
//            onNavigateToRegister = onNavigateToRegister)
//    }
//
//
//    fun NavController.navigateToRegisterProfile() {
//        this.navigate(RegisterProfileInfoRoute)
//    }
//
//}