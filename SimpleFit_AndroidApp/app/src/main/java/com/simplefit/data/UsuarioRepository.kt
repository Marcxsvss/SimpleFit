package com.simplefit.data

//import com.simplefit.data.services.usuario.UsuarioServiceImplementation
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.data.services.usuario.UsuarioServiceImplementation
import com.simplefit.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRepository @Inject constructor(
    private val usuarioDao: UsuarioDao,
    private val usuarioServiceImplementation: UsuarioServiceImplementation
) {
    //    suspend fun get(email: String): Usuario? =
//        withContext(Dispatchers.IO) {
//            usuarioDao.get(email)?.toUsuario()
//        } //El problema está en cuando intento obtener un email que no existe
//
//    suspend fun insert(usuario: Usuario) =
//        withContext(Dispatchers.IO) { usuarioDao.insert(usuario.toUsuarioEntity()) }
//
//    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
//        usuarioDao.update(usuario.toUsuarioEntity())
//    }
//    suspend fun updateRutinaState(userid: String, rutinaState: Int) = withContext(Dispatchers.IO) {
//        val usuario = usuarioDao.get(userid).copy(rutinaState = rutinaState)
//        usuarioDao.update(usuario)
//    }
    suspend fun get(email: String): Usuario? =
        withContext(Dispatchers.IO) {
            usuarioServiceImplementation.get(email)?.toUsuario()
        } //El problema está en cuando intento obtener un email que no existe

    suspend fun insert(usuario: Usuario) =
        withContext(Dispatchers.IO) { usuarioServiceImplementation.insert(usuario.toUsuarioApi()) }

    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
        usuarioServiceImplementation.update(usuario.toUsuarioApi())
    }

    suspend fun updateRutinaState(userid: String, rutinaState: Int) = withContext(Dispatchers.IO) {
        val usuario = usuarioServiceImplementation.get(userid).copy(rutinaState = rutinaState)
        usuarioServiceImplementation.update(usuario)
    }


}