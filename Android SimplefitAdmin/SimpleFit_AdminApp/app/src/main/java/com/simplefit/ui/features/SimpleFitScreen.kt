package com.simplefit.ui.features


import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.simplefit.ui.navigation.SimpleFitNavHost


@SuppressLint("UnrememberedMutableState")
@Composable
fun SimpleFitScreen() {
    val navController = rememberNavController()
    SimpleFitNavHost(navController = navController)
}
