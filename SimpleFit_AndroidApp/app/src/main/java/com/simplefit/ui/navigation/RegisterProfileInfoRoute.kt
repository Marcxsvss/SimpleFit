package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.userAuthentication.profileInfoRegister.RegisterProfileInfoScreen
import com.simplefit.ui.features.userAuthentication.profileInfoRegister.RegisterProfileInfoViewModel

const val RegisterProfileInfoRoute="registerProfileInfo"
const val registerProfileParameterName = "email"
fun NavGraphBuilder.registerProfileInfoScreen(
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
        //registerProfileInfoViewModel.setUsuario(email ?: "Email erroneo")

        RegisterProfileInfoScreen(
            registerProfileInfoUiState = registerProfileInfoViewModel.perfilUsuarioUiState,
            mostrarSnack = registerProfileInfoViewModel.mostrarSnackBar,
            onMostrarSnackBar = registerProfileInfoViewModel.onMostrarSnackBar,
            validacionRegisterProfileInfoUiState = registerProfileInfoViewModel.validacionRegisterProfileInfoUiState,
            onRegisterProfileInfoEvent = registerProfileInfoViewModel::onRegisterProfileInfoEvent,
            onNavigateToHome = onNavigateToHome,
            emailState = email ?: "Email erroneo"
        )
    }
}
fun NavController.navigateToRegisterProfile(email : String,navOptions: NavOptions? = null) {
    val ruta = RegisterProfileInfoRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$email", navOptions)
}