package com.simplefit.data

import com.pmdm.recetas.data.mocks.UsuarioMock
import com.pmdm.tienda.data.room.cliente.UsuarioEntity
import com.simplefit.data.services.UsuarioApi
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
    this.alergia
)

fun Usuario.toUsuarioEntity(): UsuarioEntity = UsuarioEntity(
    this.email,
    this.dni,
    this.contraseña,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.alergia
)


fun List<UsuarioEntity>.toRecipe() = this.map { it.toUsuario() }.toMutableList()

//region usuarioEntity

fun List<UsuarioEntity>.toUsuarios(): List<Usuario> =
    this.map { it.toUsuario() }


//endregion

//region UsuarioMock
fun UsuarioMock.toUsuario(): Usuario = Usuario(
    this.email,
    this.dni,
    this.contraseña,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.alergia
)
fun Usuario.toUsuarioApi() = UsuarioApi(
    this.email,
    this.dni,
    this.contraseña,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.alergia
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
    this.alergia
)
//endregion