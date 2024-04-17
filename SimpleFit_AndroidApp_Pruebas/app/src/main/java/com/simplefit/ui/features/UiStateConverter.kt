package com.simplefit.ui.features

import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaUiState
import com.simplefit.ui.features.userAuthentication.accountInfoRegister.RegisterAccountInfoUiState
import com.simplefit.ui.features.userAuthentication.login.LoginUiState

fun Usuario.toLoginUiState(): LoginUiState = LoginUiState(
    this.email,
    this.password,
    false

)


fun LoginUiState.toUsuario(): Usuario = Usuario(
    this.email,
    "",
this.password,
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
fun Rutinas.toRutinasUiState(): RoutinesUiState = RoutinesUiState(
    rutinaid = this.rutinaid,
    userid = this.userid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    objetivo = this.objetivo,
    frecuencia = this.frecuencia
)
fun RoutinesUiState.toVerRutinaUiState(): VerRutinaUiState = VerRutinaUiState(
    rutinaid = this.rutinaid,
    userid = this.userid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    objetivo = this.objetivo,
    frecuencia = this.frecuencia
)
//fun MutableList<Recipe>.toRecipeUiState() = this.map { it.toRecipeUiState() }.toMutableList()
//
//fun Usuario.toUsuarioUiState():LoginUiState= LoginUiState(login,password,true,likeds)
//fun LoginUiState.toUsuario() = Usuario(this.login, this.password,this.likeds)
//
