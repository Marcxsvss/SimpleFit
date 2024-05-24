package com.simplefit.data


import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRepository @Inject constructor(
    private val usuarioDao: UsuarioDao,

) {
    suspend fun get(email: String): Usuario? =
        withContext(Dispatchers.IO) {
            usuarioDao.get(email)?.toUsuario()
        }

    suspend fun get(): List<Usuario> =
        withContext(Dispatchers.IO) {
            usuarioDao.get().map { it.toUsuario() }
        }

    suspend fun insert(usuario: Usuario) =
        withContext(Dispatchers.IO) { usuarioDao.insert(usuario.toUsuarioEntity()) }

    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
        usuarioDao.update(usuario.toUsuarioEntity())
    }

    suspend fun delete(email: String) = withContext(Dispatchers.IO) {
        usuarioDao.delete(email)
    }

}