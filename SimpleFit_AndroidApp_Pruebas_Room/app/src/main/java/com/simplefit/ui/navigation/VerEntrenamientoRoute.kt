package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.verEntrenamiento.VerEntrenamientoScreen
import com.simplefit.ui.features.mainApp.verEntrenamiento.VerEntrenamientoViewModel
import com.simplefit.ui.features.mainApp.verRutina.VerRoutinesScreen
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaViewModel

const val VerEntrenamientoRoute = "VerEntrenamiento"
const val VerEntrenamientoParameterName = "rutinaid"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.verEntrenamientoScreen(
    verEntrenamientoViewModel: VerEntrenamientoViewModel,
    onNavigateToPrevious: () -> Unit,
) {
    composable(
        route = "$VerEntrenamientoRoute/{$VerEntrenamientoParameterName}",
        arguments = listOf(
            navArgument(VerEntrenamientoParameterName) {
                type = NavType.StringType
            }
        )
    ) {
        VerEntrenamientoScreen(
            verEntrenamientoState = verEntrenamientoViewModel.verRutinaUiState,
            onVerEntrenamientoEvent = verEntrenamientoViewModel::onVerRoutinesEvent,
            dia = verEntrenamientoViewModel.dia,
            onMostrarDialog = verEntrenamientoViewModel.onMostrarDialog,
            mostrarDialog = verEntrenamientoViewModel.mostrarDialog,
            maquinaUiState = verEntrenamientoViewModel.maquinaUiState,
            onNavigateToPrevious = onNavigateToPrevious
        )
    }

}
fun NavController.navigateToVerEntrenamiento(rutina: RoutinesUiState, navOptions: NavOptions? = null){
    val ruta = VerEntrenamientoRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$rutina", navOptions)
}
