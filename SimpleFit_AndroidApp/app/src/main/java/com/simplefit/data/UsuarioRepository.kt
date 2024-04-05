package com.simplefit.data

//import com.simplefit.data.services.usuario.UsuarioServiceImplementation
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRepository @Inject constructor(
    private val usuarioDao: UsuarioDao
) {
    init {
        //Para inicializar con datos la BD
//        runBlocking {
//            proveedorUsuarios.insert(UsuarioEntity("pepe@gmail.com", "2347850239Y", "pepe1234"))
//            proveedorUsuarios.insert(UsuarioEntity("juanjo@gmail.com", "467545631I","juanjo1234"))
//            proveedorUsuarios.insert(UsuarioEntity("xusa@gmail.com","98967089O" ,"xusa1234"))
//        }
    }

//    suspend fun get(email: String): Usuario? =
//        withContext(Dispatchers.IO) { usuarioService.get(email).toUsuario() }
//
//    suspend fun insert(usuario: Usuario) =
//        withContext(Dispatchers.IO) { usuarioService.insert(usuario.toUsuarioApi()) }
//
//    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
//        usuarioService.update(usuario.toUsuarioApi())
//    }
//    suspend fun delete(email: String) = withContext(Dispatchers.IO) {
//        usuarioService.delete(email)
//    }
suspend fun get(email: String): Usuario? =
        withContext(Dispatchers.IO) { usuarioDao.get(email)?.toUsuario() } //El problema está en cuando intento obtener un email que no existe

    suspend fun insert(usuario: Usuario) =
        withContext(Dispatchers.IO) { usuarioDao.insert(usuario.toUsuarioEntity()) }

    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
      usuarioDao.update(usuario.toUsuarioEntity())
    }
//    suspend fun delete(email: String) = withContext(Dispatchers.IO) {
//        usuarioService.delete(email)
//    }

}