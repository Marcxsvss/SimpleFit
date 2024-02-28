package com.simplefit.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.EventNote
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Dehaze
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsGymnastics
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Icon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(
    indexScreenState: Int,
    onNavigateToScreen: (Int) -> Unit
) {
    val titlesAndIcons = remember {
        listOf(
            "Pantalla 1" to Icons.Filled.Home,
            "Pantalla 2" to Icons.AutoMirrored.Filled.List,
            "Pantalla 3" to Icons.Filled.Person
        )
    }

    NavigationBar {
        titlesAndIcons.forEachIndexed { index, (title, icon) ->
            NavigationBarItem(
                icon = { Icon(imageVector = icon, contentDescription = title) },
                label = { },
                selected = indexScreenState == index,
                onClick = { onNavigateToScreen(index) }
            )
        }
    }
}
@Preview
@Composable
fun NavBarPreview()
{
    NavBar(0, {})
}