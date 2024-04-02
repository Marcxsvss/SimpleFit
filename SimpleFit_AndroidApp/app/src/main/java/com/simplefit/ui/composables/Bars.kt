package com.simplefit.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Icon
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.simplefit.ui.navigation.navigateToHome
import com.simplefit.ui.navigation.navigateToHome2
import com.simplefit.ui.navigation.navigateToProfile
import com.simplefit.ui.navigation.navigateToRoutines


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(
    navController: NavController,
    currentIndex: Int = 0
) {
    @Immutable
    data class ItemIconButton(
        val icon: ImageVector,
        val description: String? = null,
        val title: String,
        val onClick: () -> Unit
    )

    val listItemsIconButtons:List<ItemIconButton> = listOf(
        ItemIconButton(
            icon = Icons.Filled.Home,
            description = "home",
            title = "Home",
            onClick = { navController.navigateToHome2() }
        ),
        ItemIconButton(
            icon = Icons.AutoMirrored.Filled.List,
            description = "list",
            title = "List",
            onClick = { navController.navigateToRoutines() }
        ),
        ItemIconButton(
            icon = Icons.Filled.Person,
            description = "profile",
            title = "Profile",
            onClick = { navController.navigateToProfile() }
        )
    )

    var selectedItem: Int by remember { mutableIntStateOf(currentIndex) }

    NavigationBar(containerColor = Color(0xFFdbc06d)) {
        listItemsIconButtons.forEachIndexed { index, button ->
            NavigationBarItem(
                icon = { Icon(imageVector = button.icon, contentDescription = button.title) },
                label = { },
                selected = selectedItem == index,
                onClick = { button.onClick()
                    selectedItem = index}
            )
        }
    }
}

@Preview
@Composable
fun NavBarPreview()
{
    //NavBar(0, {})
}