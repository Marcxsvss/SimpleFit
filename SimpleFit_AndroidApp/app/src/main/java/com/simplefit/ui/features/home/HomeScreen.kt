package com.simplefit.ui.features.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    onHomeEvent: (HomeEvent) -> Unit,
    onNavigateToLogin: () -> Unit
)
{
    Text(text= "Hola")
}
@Preview
@Composable
fun HomeScreenPreview()
{
     //HomeScreen()

}