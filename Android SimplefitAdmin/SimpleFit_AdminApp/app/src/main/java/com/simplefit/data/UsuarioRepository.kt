package com.simplefit.data



import com.simplefit.data.services.usuario.UsuarioServiceImplementation
import com.simplefit.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRepository @Inject constructor(
    private val usuarioServiceImplementation: UsuarioServiceImplementation
) {

suspend fun get(): List<Usuario> =
    withContext(Dispatchers.IO) {
        usuarioServiceImplementation.get().map { it.toUsuario() }
    }
    suspend fun get(email: String): Usuario? =
        withContext(Dispatchers.IO) {
            usuarioServiceImplementation.get(email)?.toUsuario()
        } //El problema está en cuando intento obtener un email que no existe

    suspend fun delete(email: String) = withContext(Dispatchers.IO) {
        usuarioServiceImplementation.delete(email)
    }
    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
        usuarioServiceImplementation.update(usuario.toUsuarioApi())
    }

    suspend fun updateRutinaState(userid: String, rutinaState: Int) = withContext(Dispatchers.IO) {
        val usuario = usuarioServiceImplementation.get(userid).copy(rutinastate = rutinaState)
        usuarioServiceImplementation.update(usuario)
    }


}