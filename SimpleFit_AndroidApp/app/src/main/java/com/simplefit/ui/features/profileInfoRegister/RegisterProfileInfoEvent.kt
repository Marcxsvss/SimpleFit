package com.simplefit.ui.features.profileInfoRegister

sealed interface RegisterProfileInfoEvent {
    data class EdadChanged(val edad: Int) : RegisterProfileInfoEvent
    data class SexoChanged(val sexo: String) : RegisterProfileInfoEvent
    data class AlturaChanged(val altura: Int) : RegisterProfileInfoEvent
    data class SomatotipoChanged(val somatotipo: String) : RegisterProfileInfoEvent
    data class PesoChanged(val peso: Int) : RegisterProfileInfoEvent
    data class AlergiaChanged(val alergia: String) : RegisterProfileInfoEvent
    data class  OnClickGuardarPerfil(val onNavigateHome:((correo:String)->Unit)?):RegisterProfileInfoEvent
    data class  OnClickGuardarPerfil1(val onNavigateHome:((correo:String)->Unit)?):RegisterProfileInfoEvent
}