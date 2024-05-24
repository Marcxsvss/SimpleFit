package com.simplefit.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.simplefit.ui.features.mainApp.home.HomeViewModel
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel
import com.simplefit.ui.features.mainApp.users.UsersViewModel
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaViewModel
import com.simplefit.ui.features.userAuthentication.login.LoginViewModel


@Composable
fun SimpleFitNavHost(
    navController: NavHostController
) {

    val loginViewModel = hiltViewModel<LoginViewModel>()
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val routinesViewModel = hiltViewModel<RoutinesViewModel>()
    val verRutinaViewModel = hiltViewModel<VerRutinaViewModel>()
    val usersViewModel = hiltViewModel<UsersViewModel>()


    NavHost(
        navController = navController,
        startDestination = LoginRoute
    ) {

        loginScreen(
            loginViewModel = loginViewModel,
            onNavigateToHome = { email ->
                navController.navigateToHome(email)
                homeViewModel.setUsuario(email)

            }
        )
        homeScreen(
            onNavigateToUsuarios = {
                usersViewModel.setUsers()
                navController.navigateToUsers()
                                   },
            onNavigateToRutinas = {
                routinesViewModel.setRoutines()
                navController.navigateToRoutines() },
        )
        routinesScreen(routinesViewModel = routinesViewModel,

            onNavigateToVerRutina = { rutinaUiState ->
                verRutinaViewModel.setRutina(rutinaUiState)
                navController.navigateToVerRutina(rutinaUiState)
            },
            onNavigateUp = { navController.navigateUp() }
        )
        verRutinaScreen(
            verRutinaViewModel = verRutinaViewModel,
            onNavigateToPrevious = { navController.navigateUp() },
        )
        usersScreen(
            usersViewModel = usersViewModel,
            onNavigateUp = { navController.navigateUp() }
        )
    }

}

