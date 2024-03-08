package com.simplefit.ui.features.mainApp.profile

sealed interface ProfileEvent {
    data class OnClickLogOut(val email : String) : ProfileEvent
    data class onPesoChanged(val peso : String) : ProfileEvent
    data class onAlturaChanged(val altura : String) : ProfileEvent
    data class onEdadChanged(val idade : String) : ProfileEvent
    data class onSexoChanged(val sexo : String) : ProfileEvent

    //Añadir los eventos necesarios


}