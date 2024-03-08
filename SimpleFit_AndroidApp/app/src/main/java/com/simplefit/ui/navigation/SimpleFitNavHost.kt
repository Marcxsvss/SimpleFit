package com.simplefit.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.simplefit.ui.features.mainApp.home.HomeViewModel
import com.simplefit.ui.features.mainApp.profile.ProfileViewModel
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel
import com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoViewModel
import com.simplefit.ui.features.userAuthentication.login.LoginViewModel
import com.simplefit.ui.features.userAuthentication.profileInfoRegister.RegisterProfileInfoViewModel

@Composable
fun SimpleFitNavHost(innerPadding: PaddingValues, navController: NavHostController) {

    val loginViewModel = hiltViewModel<LoginViewModel>()
    val accountViewModel = hiltViewModel<RegisterAccountInfoViewModel>()
    val registerProfileViewModel = hiltViewModel<RegisterProfileInfoViewModel>()
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val routinesViewModel = hiltViewModel<RoutinesViewModel>()
    val profileViewModel = hiltViewModel<ProfileViewModel>()

    //val scope= rememberCoroutineScope()
    //Puedo cojer el email desde RegisterAccount y guardarlo en una variable que puedo crear aqui mismo y usarla mas adelante al hacer la navegacion al ProfileInfo y luego home
    NavHost(
        navController = navController,
        startDestination = LoginRoute
    ) {
        var emailState: String = "Email erroneo"
        loginScreen(
            loginViewModel = loginViewModel,
            onNavigateToHome = { email ->
                navController.navigateToHome(email)//Meter este email en el viewmodel de Home
                emailState =
                    email //Esta linea de codigo es termporal ya que debe estar en algun viewmodel compratido o individual, para profile, home y routines

            },
            onNavigateToRegister = {
                navController.navigateToRegisterAccount()
            }
        )
        registerAccountInfoScreen(
            registerAccountInfoViewModel = accountViewModel,
            onNavigateToRegisterProfileInfo = { email ->
                navController.navigateToRegisterProfile(
                    email
                )
            },
            onNavigateToLogin = {
                navController.navigateUp()
            }
        )
        registerProfileInfoScreen(
            registerProfileInfoViewModel = registerProfileViewModel,
            onNavigateToHome = { email ->
                navController.navigateToHome(email) //El email se pasa directamente por el vm, y lo recibimos aquí
            }
        )
        homeScreen(
            homeViewModel = homeViewModel,
            onNavigateToLogin = {
                navController.navigateUp()
            }
        )
        routinesScreen(routinesViewModel = routinesViewModel)
        profileScreen(profileViewModel = profileViewModel)
    }

}

