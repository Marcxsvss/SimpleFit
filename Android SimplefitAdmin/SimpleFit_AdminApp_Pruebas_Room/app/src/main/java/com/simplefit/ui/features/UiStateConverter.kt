package com.simplefit.ui.features

import com.pmdm.agenda.utilities.imagenes.Imagenes
import com.simplefit.models.Maquina
import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario
import com.simplefit.models.UsuarioRutina
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.MaquinaUiState
import com.simplefit.ui.features.mainApp.users.UsersUiState
import com.simplefit.ui.features.mainApp.verRutina.VerRutinaUiState
import com.simplefit.ui.features.userAuthentication.login.LoginUiState

fun Usuario.toLoginUiState(): LoginUiState = LoginUiState(
    this.email,
    this.password,
    false

)
fun UsersUiState.toUsuario(): Usuario = Usuario(
    email = this.email,
    password=this.password,
    nombre = this.nombre,
    altura = this.altura,
    peso = this.peso,
    edad = this.edad,
    sexo = this.sexo,
    somatotipo = this.somatotipo,
    rutinaState = this.rutinaState,
    acceso = this.acceso
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
    rutinaState = null,
    acceso = 0
)
fun Usuario.toUsuarioUiState(): UsersUiState = UsersUiState(
    this.email,
    this.password,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.rutinaState,
    this.acceso
)
fun Rutinas.toRutinasUiState(): RoutinesUiState = RoutinesUiState(
    rutinaid = this.rutinaid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    frecuencia = this.frecuencia,
    diasDescanso = this.diasDescanso,
    dificultad = this.dificultad,
)
fun RoutinesUiState.toVerRutinaUiState(): VerRutinaUiState = VerRutinaUiState(
    rutinaid = this.rutinaid,
    titulo = this.titulo.ifBlank { "Plan de Entrenamiento" },
    descripcion =if(this.descripcion.isBlank()) "Descanso" else this.descripcion,
    ejercicio = listOf(),
    frecuencia = this.frecuencia,
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
