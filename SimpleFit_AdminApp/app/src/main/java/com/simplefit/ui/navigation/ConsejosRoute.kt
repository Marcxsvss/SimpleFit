package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val ConsejosRoute = "Consejos"

fun NavGraphBuilder.consejosScreen(
    //consejosViewModel: ConsejosViewModel,
    onNavigateUp : () -> Unit,
) {
//    composable(route = ConsejosRoute) {
//        ConsejosScreen(
//            consejosState = consejosViewModel.consejosList,
//            consejoSeleccionadoState = consejosViewModel.consejosUiState,
//            onConsejosEvent = consejosViewModel::onConsejosEvent,
//            onNavigateUp = onNavigateUp,
//        )
//    }
}

fun NavController.navigateToConsejos(navOptions: NavOptions? = null) {
    this.navigate(ConsejosRoute, navOptions)
}
