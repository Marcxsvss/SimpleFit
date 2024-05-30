package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.mainApp.rutinas.RutinasUiState
import com.simplefit.ui.features.mainApp.verRutina.VerRoutinesScreen
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaViewModel

const val VerRutinaRoute = "VerRutina"
const val VerRutinaParameterName = "rutinaid"


fun NavGraphBuilder.verRutinaScreen(
    verRutinaViewModel: VerRutinaViewModel,
    onNavigateToPrevious: () -> Unit,
    onNavigateToRutinas: ((userid: String) -> Unit)? = null
) {
    composable(
        route = "$VerRutinaRoute/{$VerRutinaParameterName}",
        arguments = listOf(
            navArgument(VerRutinaParameterName) {
                type = NavType.StringType
            }
        )
    ) {

        VerRoutinesScreen(
            verRutinaState = verRutinaViewModel.verRutinaUiState,
            onVerRutinaEvent = verRutinaViewModel::onVerRoutinesEvent,
            diaSeleccionado = verRutinaViewModel.diaSeleccionado,
            onMostrarDialog = verRutinaViewModel.onMostrarDialog,
            mostrarDialog = verRutinaViewModel.mostrarDialog,
            maquinaUiState = verRutinaViewModel.maquinaUiState,
            onNavigateToPrevious = onNavigateToPrevious,
            onNavigateToRutinas = onNavigateToRutinas,
            mostrarSnack = verRutinaViewModel.mostrarSnackBar,
            onMostrarSnackbar = verRutinaViewModel.onMostrarSnackBar)
    }

}
fun NavController.navigateToVerRutina(rutina: RutinasUiState, navOptions: NavOptions? = null){
    val ruta = VerRutinaRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$rutina", navOptions)
}

