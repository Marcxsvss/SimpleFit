package com.simplefit.ui.features.userAuthentication.login

sealed interface LoginEvent {
    data class EmailChanged(val login: String) : LoginEvent
    data class PasswordChanged(val password: String) : LoginEvent
    data class  OnClickLogearse(val onNavigateTienda:((correo:String)->Unit)?):LoginEvent
}