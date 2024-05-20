package com.simplefit.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.simplefit.ui.features.mainApp.routines.RoutinesScreen
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.routines.RoutinesViewModel
import com.simplefit.ui.features.mainApp.users.UsersScreen
import com.simplefit.ui.features.mainApp.users.UsersViewModel

const val UsersRoute = "Users"

fun NavGraphBuilder.usersScreen(
    usersViewModel: UsersViewModel,
    onNavigateUp : () -> Unit,
) {
    composable(route = UsersRoute) {
        UsersScreen(
            usersState = usersViewModel.usersList,
            usuarioSeleccionadoState = usersViewModel.usersUiState,
            onUsersEvent = usersViewModel::onUsersEvent,
            onNavigateUp = onNavigateUp,
            mostrarDialog = usersViewModel.mostrarDialog,
            onMostrarDialog = usersViewModel.onMostrarDialog,
            busquedaState = usersViewModel.busquedaState
        )
    }
}

fun NavController.navigateToUsers(navOptions: NavOptions? = null) {
    this.navigate(UsersRoute, navOptions)
}
