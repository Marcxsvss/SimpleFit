package com.simplefit.ui.features


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.simplefit.ui.composables.NavBar
import com.simplefit.ui.navigation.AddRutinaRoute
import com.simplefit.ui.navigation.HomeRoute
import com.simplefit.ui.navigation.ProfileRoute
import com.simplefit.ui.navigation.LoginRoute
import com.simplefit.ui.navigation.RegisterAccountInfoRoute
import com.simplefit.ui.navigation.RegisterProfileInfoRoute
import com.simplefit.ui.navigation.RoutinesRoute
import com.simplefit.ui.navigation.SimpleFitNavHost
import com.simplefit.ui.navigation.VerRutinaRoute

@SuppressLint("UnrememberedMutableState")//Para que no salte el error del remember en el derivedStateOf
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleFitScreen() {

    val comportamientoAnteScrollInf = BottomAppBarDefaults.exitAlwaysScrollBehavior()
    val navController = rememberNavController()
    val entradaEnPilaDeNavegacionActuasState = navController.currentBackStackEntryAsState()
    var iOpcionNevagacionSeleccionada = derivedStateOf {
        iOpcionNavegacionSeleccionadaAPartirDeRuta(entradaEnPilaDeNavegacionActuasState.value?.destination?.route)
    }
    var verNavegacion = derivedStateOf {
        iOpcionNevagacionSeleccionada.value != 3
                && iOpcionNevagacionSeleccionada.value != 4
                && iOpcionNevagacionSeleccionada.value != 5
                && iOpcionNevagacionSeleccionada.value != 6
                && iOpcionNevagacionSeleccionada.value != 7
    }

    Scaffold(
        modifier = Modifier.nestedScroll(comportamientoAnteScrollInf.nestedScrollConnection),
        topBar = {},
        snackbarHost = { },
        bottomBar = {
            if (verNavegacion.value)
                NavBar(
                    navController = navController,
                    currentIndex = iOpcionNevagacionSeleccionada.value
                )
        },
        content = { innerPadding ->
            SimpleFitNavHost(innerPadding = innerPadding, navController = navController)
        }
    )

}

private fun iOpcionNavegacionSeleccionadaAPartirDeRuta(route: String?): Int {
    return when (route?.substringBefore("/")) {
        HomeRoute -> 0
        RoutinesRoute -> 1
        ProfileRoute -> 2
        LoginRoute -> 3
        RegisterAccountInfoRoute -> 4
        RegisterProfileInfoRoute -> 5
        VerRutinaRoute -> 6
        AddRutinaRoute -> 7

        else -> 10
    }
}