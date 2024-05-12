package com.simplefit.data

import com.pmdm.recetas.data.mocks.UsuarioMock
import com.pmdm.tienda.data.room.cliente.UsuarioEntity
import com.simplefit.data.mocks.ConsejosMock
import com.simplefit.data.mocks.MaquinasMock
import com.simplefit.data.mocks.RutinaMaquinaMock
import com.simplefit.data.mocks.RutinasMock
import com.simplefit.data.room.consejos.ConsejosEntity
import com.simplefit.data.room.maquinas.MaquinasEntity
import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaEntity
import com.simplefit.data.room.rutinas.RutinasEntity
import com.simplefit.data.room.usuarioRutina.UsuarioRutinaEntity
import com.simplefit.data.services.consejo.ConsejosApi
import com.simplefit.data.services.maquina.MaquinasApi
import com.simplefit.data.services.rutina.RutinasApi
import com.simplefit.data.services.usuario.UsuarioApi
import com.simplefit.data.services.usuariorutina.UsuarioRutinaApi
import com.simplefit.models.Consejo
import com.simplefit.models.Maquina
import com.simplefit.models.RutinaMaquina
import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario
import com.simplefit.models.UsuarioRutina

fun UsuarioEntity.toUsuario(): Usuario = Usuario(
    this.email,
    this.dni,
    this.password,
    this.cargo,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.rutinaState
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
    rutinaState = this.rutinaState,
    cargo = this.cargo
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
    rutinaState = this.rutinaState,
    cargo = this.cargo
)
fun Usuario.toUsuarioApi() = UsuarioApi(
    this.email,
    this.dni,
    this.password,
    this.cargo,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.rutinaState

)

fun UsuarioApi.toUsuario() = Usuario(
    this.email,
    this.dni,
    this.password,
    this.cargo,
    this.nombre,
    this.altura,
    this.peso,
    this.edad,
    this.sexo,
    this.somatotipo,
    this.rutinastate
)
//endregion
//region Rutina
fun RutinasEntity.toRutina(): Rutinas = Rutinas(
    rutinaid = this.rutinaid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    frecuencia = this.frecuencia,
    diasDescanso = this.diasDescanso,
    dificultad = this.dificultad
)
fun RutinasMock.toRutina(): Rutinas = Rutinas(
    this.rutinaid,
    this.titulo,
    this.descripcion,
    this.frecuencia,
    this.diasDescanso,
    this.dificultad
)
fun Rutinas.toRutinasEntity(): RutinasEntity = RutinasEntity(
    rutinaid = this.rutinaid,
    titulo = this.titulo,
    descripcion = this.descripcion,
    frecuencia = this.frecuencia,
    diasDescanso = this.diasDescanso,
    dificultad = this.dificultad
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

fun UsuarioRutina.toUsuarioRutinaEntity() = UsuarioRutinaEntity(
    userid = this.userid,
    rutinaid = this.rutinaid
)

fun UsuarioRutinaEntity.toUsuarioRutina() = UsuarioRutina(
    userid = this.userid,
    rutinaid = this.rutinaid
)
fun ConsejosMock.toConsejo(): Consejo = Consejo(
    consejoid = this.consejoid,
    consejo = this.consejo
)
fun Consejo.toConsejoEntity(): ConsejosEntity = ConsejosEntity(
    consejoid = this.consejoid,
    consejo = this.consejo
)
//endregion

//Region

fun ConsejosApi.toConsejo(): Consejo = Consejo(
    consejoid = this.consejoid,
    consejo = this.consejo
)
fun Consejo.toConsejosApi(): ConsejosApi = ConsejosApi(
    consejoid = this.consejoid,
    consejo = this.consejo
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