package com.simplefit.ui.features.mainApp.users

sealed interface UsersEvent {
    data class onCargoChanged(val user:UsersUiState) : UsersEvent
    data class onEditClicked(val user:UsersUiState) : UsersEvent
    data object onCancelClicked : UsersEvent
    data class onUserClicked(val email: String) : UsersEvent
    data class onSearchChanged(val texto: String) : UsersEvent
    data class onVerClicked(val onNavigateToVerRutina:((rutinaid:UsersUiState)->Unit)?) : UsersEvent

    data class onAddClicked(val onNavigateToAddRutina:((userid:String)->Unit)?) : UsersEvent

    data object onDeleteClicked : UsersEvent

    data class  OnClickCrearRutina(val onNavigateProfile: () -> Unit): UsersEvent


}