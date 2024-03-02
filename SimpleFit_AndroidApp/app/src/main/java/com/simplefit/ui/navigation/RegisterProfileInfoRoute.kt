package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.login.LoginScreen
import com.simplefit.ui.features.profileInfoRegister.RegisterProfileInfoViewModel

const val RegisterProfileInfoRoute="registerProfileInfo"
const val registerProfileParameterName = "email"
fun NavGraphBuilder.RegisterProfileInfoScreen(
    registerProfileInfoViewModel: RegisterProfileInfoViewModel,
    onNavigateToHome:((correo: String) -> Unit)? = null
) {

    composable(route = "$RegisterProfileInfoRoute/{$registerProfileParameterName}",
        arguments = listOf(
            navArgument(registerProfileParameterName) {
                type = NavType.StringType
            }
        )
    ){
            backStackEntry ->
        val email :String? = backStackEntry.arguments?.getString(registerProfileParameterName, "Email erroneo")
        registerProfileInfoViewModel.setUsuario(email ?: "Email erroneo")

        com.simplefit.ui.features.profileInfoRegister.RegisterProfileInfoScreen(
            registerProfileInfoUiState = registerProfileInfoViewModel.perfilUsuarioUiState,
            mostrarSnack = registerProfileInfoViewModel.mostrarSnackBar,
            onMostrarSnackBar = registerProfileInfoViewModel.onMostrarSnackBar,
            validacionRegisterProfileInfoUiState = registerProfileInfoViewModel.validacionRegisterProfileInfoUiState,
            onRegisterProfileInfoEvent = registerProfileInfoViewModel::onRegisterProfileInfoEvent
        )
    }


    fun NavController.navigateToRegisterProfile() {
        this.navigate(RegisterProfileInfoRoute)
    }

}