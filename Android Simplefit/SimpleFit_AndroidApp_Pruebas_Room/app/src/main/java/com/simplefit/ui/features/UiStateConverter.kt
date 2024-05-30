package com.simplefit.ui.features

import com.pmdm.agenda.utilities.imagenes.Imagenes
import com.simplefit.models.Maquina
import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario
import com.simplefit.models.UsuarioRutina
import com.simplefit.ui.features.mainApp.rutinas.RutinasUiState
import com.simplefit.ui.features.mainApp.verEntrenamiento.VerEntrenamientoUiState
import com.simplefit.ui.features.mainApp.MaquinaUiState
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
this.password,
"",
"",
"",
"",
"",
"",
    null,
    cargo = 0,
    foto = null
)
fun RegisterAccountInfoUiState.toUsuario(): Usuario = Usuario(
    this.email,
    this.password,
    this.nombre,
    "",
    "",
    "",
    "",
    "",
    null,
    0,
    this.foto
)
fun Rutinas.toRutinasUiState(state : String = "",userid : String = ""): RutinasUiState = RutinasUiState(
    rutinaid = this.rutinaid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    frecuencia = this.frecuencia,
    diasDescanso = this.diasDescanso,
    dificultad = this.dificultad,
    estado = state,
    userid= userid
)
fun RutinasUiState.toVerRutinaUiState(): VerRutinaUiState = VerRutinaUiState(
    rutinaid = this.rutinaid,
    titulo = this.titulo.ifBlank { "Plan de Entrenamiento" },
    descripcion =if(this.descripcion.isBlank()) "Descanso" else this.descripcion,
    ejercicio = listOf(),
    frecuencia = this.frecuencia,
    estado = this.estado
)
fun Maquina.toMaquinaUiState() = MaquinaUiState(
    maquinaid = this.maquinaid,
    nombre = this.nombre,
    descripcion = this.descripcion,
    imagen = this.imagen?.let { Imagenes.base64ToBitmap(it) },
    musculo = this.musculo
)
fun VerRutinaUiState.toUsuarioRutina(userid : String) = UsuarioRutina(
    userid = userid,
    rutinaid = this.rutinaid)

fun RutinasUiState.toVerEntrenamientoUiState() = VerEntrenamientoUiState(
    rutinaid = this.rutinaid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    ejercicio = listOf()
)
//fun MutableList<Recipe>.toRecipeUiState() = this.map { it.toRecipeUiState() }.toMutableList()
//
//fun Usuario.toUsuarioUiState():LoginUiState= LoginUiState(login,password,true,likeds)
//fun LoginUiState.toUsuario() = Usuario(this.login, this.password,this.likeds)
//
//?.let { Imagenes.base64ToBitmap(it) }