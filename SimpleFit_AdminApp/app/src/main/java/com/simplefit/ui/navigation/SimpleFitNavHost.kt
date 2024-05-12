package com.simplefit.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.simplefit.ui.features.mainApp.MainAppViewModel
import com.simplefit.ui.features.mainApp.home.HomeViewModel
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel
import com.simplefit.ui.features.mainApp.verEntrenamiento.VerEntrenamientoViewModel
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaViewModel
import com.simplefit.ui.features.userAuthentication.login.LoginViewModel


@Composable
fun SimpleFitNavHost(
    innerPadding: PaddingValues,
    navController: NavHostController
) {

    val loginViewModel = hiltViewModel<LoginViewModel>()
    val mainAppViewModel = hiltViewModel<MainAppViewModel>()
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val routinesViewModel = hiltViewModel<RoutinesViewModel>()
    val verRutinaViewModel = hiltViewModel<VerRutinaViewModel>()
    val verEntrenamientoViewModel = hiltViewModel<VerEntrenamientoViewModel>()


    //val scope= rememberCoroutineScope()
    //Puedo cojer el email desde RegisterAccount y guardarlo en una variable que puedo crear aqui mismo y usarla mas adelante al hacer la navegacion al ProfileInfo y luego home
    NavHost(
        navController = navController,
        startDestination = LoginRoute
    ) {

        loginScreen(
            loginViewModel = loginViewModel,
            onNavigateToHome = { email ->
                routinesViewModel.setRoutines(email)
                navController.navigateToHome(email)
                homeViewModel.setUsuario(email)
            }
        )

        homeScreen(
            mainAppViewModel = mainAppViewModel,
            homeViewModel = homeViewModel,
            onNavigateToVerEntrenamiento = { rutinaUiState ->
                verEntrenamientoViewModel.setRutina(rutinaUiState)
                navController.navigateToVerEntrenamiento(rutinaUiState)
            }
        )
        routinesScreen(routinesViewModel = routinesViewModel,
            onNavigateToAddRutina = { userid ->
            },
            onNavigateToVerRutina = { rutinaUiState ->
                verRutinaViewModel.setRutina(rutinaUiState)
                navController.navigateToVerRutina(rutinaUiState)
            }
        )
        verRutinaScreen( verRutinaViewModel = verRutinaViewModel,
            onNavigateToPrevious = {navController.navigateUp()},
            onNavigateToRutinas = {userid ->
                routinesViewModel.setRoutines(userid)
                navController.navigateToRoutines2(userid)
            })
        verEntrenamientoScreen(verEntrenamientoViewModel = verEntrenamientoViewModel,
            onNavigateToPrevious = {navController.navigateUp()})
    }

}

