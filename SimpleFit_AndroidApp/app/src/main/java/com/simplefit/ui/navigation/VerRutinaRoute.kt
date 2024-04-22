package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.verRutina.VerRoutinesScreen
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaViewModel

const val VerRutinaRoute = "VerRutina"
const val VerRutinaParameterName = "rutinaid"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.verRutinaScreen(
    verRutinaViewModel: VerRutinaViewModel,
) {
    composable(
        route = "$VerRutinaRoute/{$VerRutinaParameterName}",
        arguments = listOf(
            navArgument(VerRutinaParameterName) {
                type = NavType.StringType
            }
        )
    ) {
//            backStackEntry ->
//        val email :String? = backStackEntry.arguments?.getString(HomeParameterName, "Email erroneo")
//        mainAppViewModel.setUsuario(email ?: "Email erroneo")

        VerRoutinesScreen(
            verRutinaState = verRutinaViewModel.verRutinaUiState,
            onVerRutinaEvent = verRutinaViewModel::onVerRoutinesEvent,
            diaSeleccionado = verRutinaViewModel.diaSeleccionado,
            onMostrarDialog = verRutinaViewModel.onMostrarDialog,
            mostrarDialog = verRutinaViewModel.mostrarDialog)
    }

}
fun NavController.navigateToVerRutina(rutina: RoutinesUiState, navOptions: NavOptions? = null){
    val ruta = VerRutinaRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$rutina", navOptions)
}

