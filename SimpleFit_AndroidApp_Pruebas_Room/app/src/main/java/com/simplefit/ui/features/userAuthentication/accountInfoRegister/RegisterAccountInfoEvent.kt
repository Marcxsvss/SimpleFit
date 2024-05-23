package com.simplefit.ui.features.userAuthentication.accountInfoRegister

sealed interface RegisterAccountInfoEvent {
    data class EmailChanged(val email: String) : RegisterAccountInfoEvent
    data class PasswordChanged(val password: String) : RegisterAccountInfoEvent
    data class DniChanged(val dni: String) : RegisterAccountInfoEvent
    data class NombreChanged(val nombre: String) : RegisterAccountInfoEvent
    data class  OnClickRegistrarse(val onNavigateRegisterProfileInfo:((correo:String)->Unit)?): RegisterAccountInfoEvent
}