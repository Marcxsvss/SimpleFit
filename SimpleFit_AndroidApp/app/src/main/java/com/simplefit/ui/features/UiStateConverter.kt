package com.simplefit.ui.features

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.ui.graphics.ImageBitmap
import com.pmdm.agenda.utilities.imagenes.Imagenes
import com.simplefit.models.Maquina
import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.verRutina.MaquinaUiState
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
fun Rutinas.toRutinasUiState(estado : String): RoutinesUiState = RoutinesUiState(
    rutinaid = this.rutinaid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    frecuencia = this.frecuencia,
    diasDescanso = this.diasDescanso,
    dificultad = this.dificultad,
    estado = estado
)
fun RoutinesUiState.toVerRutinaUiState(): VerRutinaUiState = VerRutinaUiState(
    rutinaid = this.rutinaid,
    titulo = this.titulo.ifBlank { "Plan de Entrenamiento" },
    descripcion =if(this.descripcion.isBlank()) "Descanso" else this.descripcion,
    listOf(),
    frecuencia = this.frecuencia
)
fun Maquina.toMaquinaUiState() = MaquinaUiState(
    maquinaid = this.maquinaid,
    nombre = this.nombre,
    descripcion = this.descripcion,
    imagen = this.imagen?.let { Imagenes.base64ToBitmap(it) },
    musculo = this.musculo
)
//fun MutableList<Recipe>.toRecipeUiState() = this.map { it.toRecipeUiState() }.toMutableList()
//
//fun Usuario.toUsuarioUiState():LoginUiState= LoginUiState(login,password,true,likeds)
//fun LoginUiState.toUsuario() = Usuario(this.login, this.password,this.likeds)
//
//?.let { Imagenes.base64ToBitmap(it) }