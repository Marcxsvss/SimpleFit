package com.simplefit.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.simplefit.ui.features.accountInfoRegister.RegisterAccountInfoScreen
import com.simplefit.ui.features.accountInfoRegister.RegisterAccountInfoViewModel
import com.simplefit.ui.features.login.LoginViewModel
import com.simplefit.ui.features.profileInfoRegister.RegisterProfileInfoViewModel

@Composable
fun SimpleFitNavHost(){
    val navController= rememberNavController()
    val loginViewModel = hiltViewModel<LoginViewModel>()
    val accountViewModel = hiltViewModel<RegisterAccountInfoViewModel>()
    val profileViewModel = hiltViewModel<RegisterProfileInfoViewModel>()
    //val scope= rememberCoroutineScope()
    //Puedo cojer el email desde RegisterAccount y guardarlo en una variable que puedo crear aqui mismo y usarla mas adelante al hacer la navegacion al ProfileInfo y luego home
    NavHost(
        navController = navController,
        startDestination = LoginRoute
    ) {
        var emailState : String = "Email erroneo"
        loginScreen (
            loginViewModel = loginViewModel,
            onNavigateToHome = {
                    email -> navController.navigateToHome(email)//Meter este email en el viewmodel de Home

            },
            onNavigateToRegister = {
                navController.navigateToRegisterAccount()
            }
        )
        registerAccountInfoScreen (
            registerAccountInfoViewModel = accountViewModel,
            onNavigateToRegisterProfileInfo = {email -> navController.navigateToRegisterProfile(email)},
            onNavigateToLogin= {
                navController.navigateUp()
            }
        )
        registerProfileInfoScreen (
            registerProfileInfoViewModel = profileViewModel,
            onNavigateToHome  = {
                    email -> navController.navigateToHome(email) //Meter este email en el viewmodel de Home
            }
        )
        homeScreen (
            onNavigateToLogin = {
                navController.navigateUp()
            }
        )
    }
}