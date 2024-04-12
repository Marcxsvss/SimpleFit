package com.simplefit.data

import com.pmdm.recetas.data.mocks.UsuarioMock
import com.pmdm.tienda.data.room.cliente.UsuarioEntity
import com.simplefit.data.mocks.RutinasMock
import com.simplefit.data.room.rutinas.RutinasEntity
import com.simplefit.data.services.usuario.UsuarioApi
import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario

fun UsuarioEntity.toUsuario(): Usuario = Usuario(
    this.email,
    this.dni,
    this.password,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.intolerancia
)

fun Usuario.toUsuarioEntity(): UsuarioEntity = UsuarioEntity(
    email = this.email,
    dni = this.dni,
    password = this.password,
    nombre = this.nombre,
    altura = this.altura,
    peso = this.peso,
    edad = this.edad,
    sexo = this.sexo,
    somatotipo = this.somatotipo,
    intolerancia = this.intolerancia
)


fun List<UsuarioEntity>.toRecipe() = this.map { it.toUsuario() }.toMutableList()

//region usuarioEntity

fun List<UsuarioEntity>.toUsuarios(): List<Usuario> =
    this.map { it.toUsuario() }


//endregion

//region UsuarioMock
fun UsuarioMock.toUsuario(): Usuario = Usuario(
    email = this.email,
    dni = this.dni,
    password = this.password,
    nombre = this.nombre,
    altura = this.altura,
    peso = this.peso,
    edad = this.edad,
    sexo = this.sexo,
    somatotipo = this.somatotipo,
    intolerancia = this.intolerancia
)
fun Usuario.toUsuarioApi() = UsuarioApi(
    this.email,
    this.dni,
    this.password,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.intolerancia
)

fun UsuarioApi.toUsuario() = Usuario(
    this.email,
    this.dni,
    this.contraseña,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.intolerancia
)
//endregion
//region Rutina
fun RutinasEntity.toRutina(): Rutinas = Rutinas(
    this.id,
    this.titulo,
    this.descripcion,
    this.objetivo,
    this.frecuencia
)
fun RutinasMock.toRutina(): Rutinas = Rutinas(
    this.id,
    this.titulo,
    this.descripcion,
    this.objetivo,
    this.frecuencia
)
fun Rutinas.toRutinasEntity(): RutinasEntity = RutinasEntity(
    id = this.id,
    titulo = this.titulo,
    descripcion = this.descripcion,
    objetivo = this.objetivo,
    frecuencia = this.frecuencia
)
//endregion