package com.simplefit.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


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
            "Pantalla 3" to Icons.Filled.Settings
        )
    }

    NavigationBar {
        titlesAndIcons.forEachIndexed { index, (title, icon) ->
            NavigationBarItem(
                icon = { Icon(
                    active = true,
                    activeContent = {
                        Icon(imageVector = Icons.Filled.Home, contentDescription = "Active Icon")
                    },
                    inactiveContent = {
                        // This is the content when the icon is inactive
                        Image(painterResource(R.drawable.ic_inactive), contentDescription = "Inactive Icon")
                    }
                ) },
                label = { Text(title) },
                selected = indexScreenState == index,
                onClick = { onNavigateToScreen(index) }
            )
        }
    }
    Icon(imageVector = Icons.Default.Backup, contentDescription = null)
}
//Icon(icon, contentDescription = title)
@Preview
@Composable
fun NavBarPreview()
{
    NavBar(0, {})
}