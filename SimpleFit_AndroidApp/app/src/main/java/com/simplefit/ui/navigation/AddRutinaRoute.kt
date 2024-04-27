package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.simplefit.ui.features.mainApp.crearRutina.AddRutinaScreen
import com.simplefit.ui.features.mainApp.crearRutina.AddRutinaViewModel
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.verRutina.VerRoutinesScreen
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaViewModel

const val AddRutinaRoute = "AddRutina"
const val AddRutinaParameterName = "userid"

// Definimos un método de extensión de NavGraphBuilder para poder
// usarlo en el contexto de nuestro NavHost
fun NavGraphBuilder.addRutinaScreen(
    addRutinaViewModel: AddRutinaViewModel,
) {
    composable(route = "$AddRutinaRoute/{$AddRutinaParameterName}",
        arguments = listOf(
            navArgument(AddRutinaParameterName) {
                type = NavType.StringType
            }
        )) {
        AddRutinaScreen(
            rutinasState = addRutinaViewModel.rutinasState,
            rutinaSeleccionadaState = addRutinaViewModel.rutinaUiState,
            onAddRutinaEvent = addRutinaViewModel::onAddRutinaEvent,
            mostrarDialog = addRutinaViewModel.mostrarDialog,
            onMostrarDialog = addRutinaViewModel.onMostrarDialog
        )
    }

}

fun NavController.navigateToAddRutina(userid: String, navOptions: NavOptions? = null) {
    val ruta = AddRutinaRoute
    Log.d("Navegacion", "Navegando a $ruta")
    this.navigate("$ruta/$userid", navOptions)
}


