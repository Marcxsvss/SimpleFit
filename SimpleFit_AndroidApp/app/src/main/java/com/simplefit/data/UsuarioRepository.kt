package com.simplefit.data

import com.simplefit.data.room.usuario.UsuarioDao
import com.pmdm.tienda.data.room.cliente.UsuarioEntity
import com.simplefit.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRepository @Inject constructor(
    private val proveedorUsuarios: UsuarioDao
) {
    init {
        //Para inicializar con datos la BD
//        runBlocking {
//            proveedorUsuarios.insert(UsuarioEntity("pepe@gmail.com", "2347850239Y", "pepe1234"))
//            proveedorUsuarios.insert(UsuarioEntity("juanjo@gmail.com", "467545631I","juanjo1234"))
//            proveedorUsuarios.insert(UsuarioEntity("xusa@gmail.com","98967089O" ,"xusa1234"))
//        }
    }

    suspend fun get(): List<Usuario> =
        withContext(Dispatchers.IO) { proveedorUsuarios.get().toUsuarios() }

    suspend fun get(login: String): Usuario? =
        withContext(Dispatchers.IO) { proveedorUsuarios.get(login)?.toUsuario() }

    suspend fun insert(usuario: Usuario) =
        withContext(Dispatchers.IO) { proveedorUsuarios.insert(usuario.toUsuarioEntity()) }

    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
        proveedorUsuarios.update(usuario.toUsuarioEntity())
    }
}