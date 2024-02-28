package com.simplefit.ui.features

import com.simplefit.models.Usuario
import com.simplefit.ui.features.login.LoginUiState
import com.simplefit.ui.features.accountInfoRegister.RegisterAccountInfoUiState
import com.simplefit.ui.features.profileInfoRegister.RegisterProfileInfoUiState

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
fun RegisterAccountInfoUiState.toUsuario(): Usuario = Usuario(
    this.email,
    this.dni,
    this.password
)
fun RegisterProfileInfoUiState.toUsuario(): Usuario = Usuario(
    this.email,
    this.dni,
    this.password
)
//fun MutableList<Recipe>.toRecipeUiState() = this.map { it.toRecipeUiState() }.toMutableList()
//
//fun Usuario.toUsuarioUiState():LoginUiState= LoginUiState(login,password,true,likeds)
//fun LoginUiState.toUsuario() = Usuario(this.login, this.password,this.likeds)
//
