package com.simplefit.data

import com.pmdm.recetas.data.mocks.UsuarioMock
import com.pmdm.tienda.data.room.cliente.UsuarioEntity
import com.simplefit.models.Usuario

fun UsuarioEntity.toUsuario(): Usuario = Usuario(
    this.email,
    this.dni,
    this.password
)

fun Usuario.toUsuarioEntity(): UsuarioEntity = UsuarioEntity(
    this.email,
    this.dni,
    this.contraseña
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
    this.password
)
//endregion