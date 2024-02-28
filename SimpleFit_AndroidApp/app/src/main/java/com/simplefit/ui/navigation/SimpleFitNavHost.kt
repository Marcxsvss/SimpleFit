package com.simplefit.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.simplefit.ui.features.login.LoginViewModel

@Composable
fun SimpleFitNavHost(){
    val navController= rememberNavController()
    val loginViewModel = hiltViewModel<LoginViewModel>()
    val scope= rememberCoroutineScope()
    NavHost(navController,startDestination = LoginRoute)
    {
        loginScreen(loginViewModel) {}
    }
}