package com.simplefit.ui.features.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.simplefit.ui.composables.NavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    onHomeEvent: (HomeEvent) -> Unit,
    onNavigateToLogin: () -> Unit,
    indexState : Int
)
{

    val comportamientoAnteScrollInf = BottomAppBarDefaults.exitAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(comportamientoAnteScrollInf.nestedScrollConnection),
        topBar = {},
        snackbarHost = { },
        bottomBar = {
            NavBar(indexScreenState = indexState, onHomeEvent = onHomeEvent)
        },
        content = { innerPadding ->
            if(indexState == 0)
            {
                MainCointent(
                    modifier = Modifier.padding(innerPadding),

                )
            }
            if(indexState == 1)
            {
                Text("Pantalla 2")
            }
            if(indexState == 2)
            {
                Text("Pantalla 3")
            }

        }
    )
}

@Composable
fun MainCointent(modifier: Modifier) {

}

@Preview
@Composable
fun HomeScreenPreview()
{
     //HomeScreen()

}