package com.simplefit.ui.features.accountInfoRegister

sealed interface RegisterAccountInfoEvent {
    data class EmailChanged(val login: String) : RegisterAccountInfoEvent
    data class PasswordChanged(val password: String) : RegisterAccountInfoEvent
    data class DniChanged(val dni: String) : RegisterAccountInfoEvent
    data class  OnClickRegistrarse(val onNavigateHome:((correo:String)->Unit)?):RegisterAccountInfoEvent
}