package com.simplefit.ui.features.userAuthentication.profileInfoRegister

sealed interface RegisterProfileInfoEvent {
    data class EdadChanged(val edad: String) : RegisterProfileInfoEvent
    data class SexoChanged(val sexo: String) : RegisterProfileInfoEvent
    data class AlturaChanged(val altura: String) : RegisterProfileInfoEvent
    data class SomatotipoChanged(val somatotipo: String) : RegisterProfileInfoEvent
    data class PesoChanged(val peso: String) : RegisterProfileInfoEvent
    data class AlergiaChanged(val alergia: String) : RegisterProfileInfoEvent
    data class  OnClickGuardarPerfil(val onNavigateHome:((correo:String)->Unit)?):RegisterProfileInfoEvent
    data class  OnClickGuardarPerfil1(val onNavigateHome:((correo:String)->Unit)?):RegisterProfileInfoEvent
}