package com.simplefit.ui.features.mainApp.users

sealed interface UsersEvent {
    data class onCargoChanged(val user:UsersUiState) : UsersEvent
    data object onCancelClicked : UsersEvent
    data class onUserClicked(val email: String) : UsersEvent
    data class onSearchChanged(val texto: String) : UsersEvent
    data class onVerClicked(val onNavigateToVerRutina:((rutinaid:UsersUiState)->Unit)?) : UsersEvent
    data object onDeleteClicked : UsersEvent



}