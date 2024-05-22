package com.simplefit.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.simplefit.ui.features.mainApp.crearRutina.AddRutinaViewModel
import com.simplefit.ui.features.mainApp.home.HomeViewModel
import com.simplefit.ui.features.mainApp.profile.ProfileViewModel
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel
import com.simplefit.ui.features.mainApp.verEntrenamiento.VerEntrenamientoViewModel
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaViewModel
import com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoViewModel
import com.simplefit.ui.features.userAuthentication.login.LoginViewModel
import com.simplefit.ui.features.userAuthentication.profileInfoRegister.RegisterProfileInfoViewModel

@Composable
fun SimpleFitNavHost(
    innerPadding: PaddingValues,
    navController: NavHostController
) {

    val loginViewModel = hiltViewModel<LoginViewModel>()
    val accountViewModel = hiltViewModel<RegisterAccountInfoViewModel>()
    val registerProfileViewModel = hiltViewModel<RegisterProfileInfoViewModel>()
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val routinesViewModel = hiltViewModel<RoutinesViewModel>()
    val profileViewModel = hiltViewModel<ProfileViewModel>()
    val verRutinaViewModel = hiltViewModel<VerRutinaViewModel>()
    val addRutinaViewModel = hiltViewModel<AddRutinaViewModel>()
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
                profileViewModel.setUserEmail(email)
                homeViewModel.setUsuario(email)
            },
            onNavigateToRegister = {

                navController.navigateToRegisterAccount()
            }
        )
        registerAccountInfoScreen(
            registerAccountInfoViewModel = accountViewModel,
            onNavigateToRegisterProfileInfo = { email ->
                registerProfileViewModel.accountMail = email
                routinesViewModel.setRoutines(email)
                profileViewModel.setUserEmail(email)
                homeViewModel.setUsuario(email)
                navController.navigateToRegisterProfile(email)
            },
            onNavigateToLogin = {
                navController.navigateUp()
            }
        )
        registerProfileInfoScreen(
            registerProfileInfoViewModel = registerProfileViewModel,
            onNavigateToHome = { email ->
                homeViewModel.setUsuario(email)
                profileViewModel.setUserEmail(email)
                navController.navigateToHome(email)
            }
        )
        homeScreen(
            homeViewModel = homeViewModel,
            onNavigateToVerEntrenamiento = { rutinaUiState ->
                verEntrenamientoViewModel.setRutina(rutinaUiState)
                navController.navigateToVerEntrenamiento(rutinaUiState)
            }
        )
        routinesScreen(routinesViewModel = routinesViewModel,
            onNavigateToAddRutina = { userid ->
                addRutinaViewModel.setRutinas(userid)
                navController.navigateToAddRutina(userid)
            },
            onNavigateToVerRutina = { rutinaUiState ->
                verRutinaViewModel.setRutina(rutinaUiState)
                navController.navigateToVerRutina(rutinaUiState)
            }
        )
        profileScreen(
            profileViewModel = profileViewModel,
            onNavigateToLogin = {
                loginViewModel.logout()

                navController.navigateToLogin()
            })
        verRutinaScreen( verRutinaViewModel = verRutinaViewModel,
            onNavigateToPrevious = {navController.navigateUp()},
            onNavigateToRutinas = {userid ->
                homeViewModel.setUsuario(userid)
                routinesViewModel.setRoutines(userid)
                navController.navigateToRoutines()
            })

        addRutinaScreen(addRutinaViewModel = addRutinaViewModel,
            onNavigateToVerRutina = { rutinaUiState ->
                verRutinaViewModel.setRutina(rutinaUiState)
                navController.navigateToVerRutina(rutinaUiState)
            },
            onNavigateUp = {navController.navigateUp()})
        verEntrenamientoScreen(verEntrenamientoViewModel = verEntrenamientoViewModel,
            onNavigateToPrevious = {navController.navigateUp()})
    }

}

