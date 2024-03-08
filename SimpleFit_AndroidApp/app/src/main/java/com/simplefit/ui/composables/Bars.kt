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
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.simplefit.ui.features.mainApp.home.HomeEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(
    indexScreenState: Int,
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToList: () -> Unit
) {
    @Immutable
    data class ItemIconButton(
        val icon: ImageVector,
        val description: String? = null,
        val title: String,
        val onClick: () -> Unit
    )

    val listItemsIconButtons:List<ItemIconButton> = listOf<ItemIconButton>(
        ItemIconButton(
            icon = Icons.Filled.Home,
            description = "home",
            title = "Home",
            onClick = onNavigateToHome
        ),
        ItemIconButton(
            icon = Icons.AutoMirrored.Filled.List,
            description = "list",
            title = "List",
            onClick = onNavigateToList
        ),
        ItemIconButton(
            icon = Icons.Filled.Person,
            description = "profile",
            title = "Profile",
            onClick = onNavigateToProfile
        )
    )

    var selectedItem: Int by remember { mutableIntStateOf(indexScreenState) }

    NavigationBar {
        listItemsIconButtons.forEachIndexed { index, button ->
            NavigationBarItem(
                icon = { Icon(imageVector = button.icon, contentDescription = button.title) },
                label = { },
                selected = selectedItem == index,
                onClick = { button.onClick
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