package com.simplefit.ui.features.userAuthentication.accountInfoRegister

sealed interface RegisterAccountInfoEvent {
    data class EmailChanged(val email: String) :
        com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoEvent
    data class PasswordChanged(val password: String) :
        com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoEvent
    data class DniChanged(val dni: String) :
        com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoEvent
    data class NombreChanged(val nombre: String) :
        com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoEvent
    data class  OnClickRegistrarse(val onNavigateRegisterProfileInfo:((correo:String)->Unit)?):
        com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoEvent
}