package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.simplefit.ui.features.accountInfoRegister.RegisterAccountInfoScreen
import com.simplefit.ui.features.accountInfoRegister.RegisterAccountInfoViewModel
import com.simplefit.ui.features.login.LoginScreen
import com.simplefit.ui.features.login.LoginViewModel

const val RegisterAccountInfoRoute = "registerAccountInfo"
const val registerAccountParameterName = "email"
fun NavGraphBuilder.registerAccountInfoScreen(
    registerAccountInfoViewModel: RegisterAccountInfoViewModel,
    onNavigateToRegisterProfileInfo: ((correo: String) -> Unit)? = null,
    onNavigateToLogin: () -> Unit
) {

    composable(RegisterAccountInfoRoute) {
        RegisterAccountInfoScreen(
            registerAccountInfoUiState = registerAccountInfoViewModel.nuevoUsuarioUiState,
            mostrarSnack = registerAccountInfoViewModel.mostrarSnackBar,
            onMostrarSnackBar = registerAccountInfoViewModel.onMostrarSnackBar,
            validacionRegisterAccountInfoUiState = registerAccountInfoViewModel.validacionRegisterAccountInfoUiState,
            onRegisterAccountInfoEvent = registerAccountInfoViewModel::onRegisterAccountInfoEvent)
    }


    fun NavController.navigateToRegisterAccountInfo() {
        this.navigate(RegisterAccountInfoRoute)
    }

}