package com.simplefit.ui.features

import com.simplefit.models.Usuario
import com.simplefit.ui.features.login.LoginUiState

fun Usuario.toLoginUiState(): LoginUiState = LoginUiState(
    this.email,
    this.contraseña,
    false

)

fun LoginUiState.toUsuario(): Usuario = Usuario(
    this.email,
    "0",
    this.password
)
//fun MutableList<Recipe>.toRecipeUiState() = this.map { it.toRecipeUiState() }.toMutableList()
//
//fun Usuario.toUsuarioUiState():LoginUiState= LoginUiState(login,password,true,likeds)
//fun LoginUiState.toUsuario() = Usuario(this.login, this.password,this.likeds)
//
