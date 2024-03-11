package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoScreen
import com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoViewModel

const val RegisterAccountInfoRoute = "registerAccountInfo"
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
            onRegisterAccountInfoEvent = registerAccountInfoViewModel::onRegisterAccountInfoEvent,
            onNavigateToRegisterProfileInfo = onNavigateToRegisterProfileInfo,
            onNavigateToLogin = onNavigateToLogin
        )
    }

}
fun NavController.navigateToRegisterAccount(navOptions: NavOptions? = null) {
    val ruta = RegisterAccountInfoRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate(ruta, navOptions)
}