package com.simplefit.ui.features.profileInfoRegister

sealed interface RegisterProfileInfoEvent {
    data class EmailChanged(val login: String) : RegisterProfileInfoEvent
    data class PasswordChanged(val password: String) : RegisterProfileInfoEvent
    data class DniChanged(val dni: String) : RegisterProfileInfoEvent
    data class  OnClickGuardarPerfil(val onNavigateHome:((correo:String)->Unit)?):RegisterProfileInfoEvent
}