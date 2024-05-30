package com.simplefit.ui.features.mainApp.perfil

sealed interface ProfileEvent {
    data class onClickLogOut(val email : String) : ProfileEvent
    data class PesoChanged(val peso : String) : ProfileEvent
    data class AlturaChanged(val altura : String) : ProfileEvent
    data class EdadChanged(val edad : String) : ProfileEvent
    data class SexoChanged(val sexo : String) : ProfileEvent
    data class SomatotipoChanged(val somatotipo : String) : ProfileEvent
    object onClickGuardarPerfil : ProfileEvent


}