package com.simplefit.ui.features

import com.simplefit.models.Usuario
import com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoUiState
import com.simplefit.ui.features.userAuthentication.login.LoginUiState

fun Usuario.toLoginUiState(): LoginUiState = LoginUiState(
    this.email,
    this.contraseña,
    false

)


fun LoginUiState.toUsuario(): Usuario = Usuario(
    this.email,
    this.password,
"",
"",
"",
"",
"",
"",
"",
""
)
fun RegisterAccountInfoUiState.toUsuario(): Usuario = Usuario(
    this.email,
    this.dni,
    this.password,
    this.nombre,
    "",
    "",
    "",
    "",
    "",
    ""
)

//fun MutableList<Recipe>.toRecipeUiState() = this.map { it.toRecipeUiState() }.toMutableList()
//
//fun Usuario.toUsuarioUiState():LoginUiState= LoginUiState(login,password,true,likeds)
//fun LoginUiState.toUsuario() = Usuario(this.login, this.password,this.likeds)
//
