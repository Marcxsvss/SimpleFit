package com.simplefit.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


//const val homeRoute = "Home"
//const val homeParameterName = "email"
//
//// Definimos un método de extensión de NavGraphBuilder para poder
//// usarlo en el contexto de nuestro NavHost
//fun NavGraphBuilder.homeScreen(
//    vm : HomeViewModel,
//    onNavigateToLogin: () -> Unit,
//) {
//    composable(
//        route = "$homeRoute/{$homeParameterName}",
//        arguments = listOf(
//            navArgument(homeParameterName) {
//                type = NavType.StringType
//            }
//        )
//    ) { backStackEntry ->
//        val email :String? = backStackEntry.arguments?.getString(homeParameterName, "Email erroneo")
//        vm.setUsuario(email ?: "Email erroneo")
//
//        HomeScreen(
//            currentRoutine = vm.routineState,
//            onHomeEvent = vm::onHomeEvent,
//            onNavigateToLogin = onNavigateToLogin,
//            login = email ?: "Email erroneo"
//        )
//    }
//}
//fun NavController.navigateToHome(email: String,navOptions: NavOptions? = null) {
//    val ruta = homeRoute
//    Log.d("Navegacion", "Navegando a $ruta")
//    this.navigate("$ruta/$email", navOptions)
//}
