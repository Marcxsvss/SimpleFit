package com.simplefit.data

import com.pmdm.recetas.data.mocks.UsuarioMock
import com.pmdm.tienda.data.room.cliente.UsuarioEntity
import com.simplefit.data.mocks.MaquinasMock
import com.simplefit.data.mocks.RutinaMaquinaMock
import com.simplefit.data.mocks.RutinasMock
import com.simplefit.data.room.maquinas.MaquinasEntity
import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaEntity
import com.simplefit.data.room.rutinas.RutinasEntity
import com.simplefit.data.services.usuario.UsuarioApi
import com.simplefit.models.Maquina
import com.simplefit.models.RutinaMaquina
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
    this.rutinaid,
    this.userid,
    this.titulo,
    this.descripcion,
    this.objetivo,
    this.frecuencia
)
fun RutinasMock.toRutina(): Rutinas = Rutinas(
    this.rutinaid,
    this.userid,
    this.titulo,
    this.descripcion,
    this.objetivo,
    this.frecuencia
)
fun Rutinas.toRutinasEntity(): RutinasEntity = RutinasEntity(
    rutinaid = this.rutinaid,
    userid = this.userid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    objetivo = this.objetivo,
    frecuencia = this.frecuencia
)
fun MaquinasMock.toMaquina(): Maquina = Maquina(
    maquinaid = this.maquinaid,
    nombre = this.nombre,
    musculo = this.musculo,
    imagen = this.imagen,
    descripcion = this.descripcion
)
fun Maquina.toMaquinaEntity(): MaquinasEntity = MaquinasEntity(
    maquinaid = this.maquinaid,
    nombre = this.nombre,
    musculo = this.musculo,
    imagen = this.imagen,
    descripcion = this.descripcion
)
fun RutinaMaquinaMock.toRutinaMaquina(): RutinaMaquina = RutinaMaquina(
    rutinaid = this.rutinaid,
    dia = this.dia,
    maquinaid = this.maquinaid
)
fun RutinaMaquina.toRutinaMaquinaEntity(): RutinaMaquinaEntity = RutinaMaquinaEntity(
    rutinaid = this.rutinaid,
    dia = this.dia,
    maquinaid = this.maquinaid
)

//endregion