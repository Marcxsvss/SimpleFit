package com.simplefit.ui.features.mainApp.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    onHomeEvent: (HomeEvent) -> Unit,
    onNavigateToLogin: () -> Unit,

) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Home Screen")
    }
}