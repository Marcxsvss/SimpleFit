package com.simplefit.data


import com.simplefit.data.services.maquina.MaquinasApi
import com.simplefit.data.services.rutina.RutinasApi
import com.simplefit.data.services.usuario.UsuarioApi
import com.simplefit.data.services.usuariorutina.UsuarioRutinaApi
import com.simplefit.models.Maquina
import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario
import com.simplefit.models.UsuarioRutina



fun Usuario.toUsuarioApi() = UsuarioApi(
    this.email,
    this.password,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.rutinaState,
    this.acceso,
    this.foto

)

fun UsuarioApi.toUsuario() = Usuario(
    this.email,
    this.password,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.rutinastate,
    this.acceso,
    this.foto
)

fun MaquinasApi.toMaquina(): Maquina = Maquina(
    maquinaid = this.maquinaid,
    nombre = this.nombre,
    musculo = this.musculo,
    imagen = this.imagen,
    descripcion = this.descripcion
)
fun Maquina.toMaquinasApi(): MaquinasApi = MaquinasApi(
    maquinaid = this.maquinaid,
    nombre = this.nombre,
    musculo = this.musculo,
    imagen = this.imagen,
    descripcion = this.descripcion
)
fun RutinasApi.toRutina(): Rutinas = Rutinas(
    rutinaid = this.rutinaid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    frecuencia = this.frecuencia,
    diasDescanso = this.diasdescanso,
    dificultad = this.dificultad
)
fun Rutinas.toRutinaApi(): RutinasApi = RutinasApi(
    rutinaid = this.rutinaid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    frecuencia = this.frecuencia,
    diasdescanso = this.diasDescanso,
    dificultad = this.dificultad)
fun UsuarioRutina.toUsuarioRutinaApi(): UsuarioRutinaApi = UsuarioRutinaApi(
    userid = this.userid,
    rutinaid = this.rutinaid
)
fun UsuarioRutinaApi.toUsuarioRutina(): UsuarioRutina = UsuarioRutina(
    userid = this.userid,
    rutinaid = this.rutinaid
)