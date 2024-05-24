package com.simplefit.data

import com.simplefit.data.services.usuario.UsuarioServiceImplementation
import com.simplefit.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRepository @Inject constructor(
    private val usuarioServiceImplementation: UsuarioServiceImplementation
) {

    suspend fun get(email: String): Usuario? =
        withContext(Dispatchers.IO) {
            usuarioServiceImplementation.get(email)?.toUsuario()
        }
    suspend fun comprobarEmail(email: String): Usuario? =
        withContext(Dispatchers.IO) {
            usuarioServiceImplementation.comprobarEmail(email)?.toUsuario()
        }
    suspend fun getRutinas(email: String): List<Int>? =
        withContext(Dispatchers.IO) {
            usuarioServiceImplementation.rutinas(email).map { it.rutinaid }
        }
    suspend fun delete(email: String, rutinaid: Int) =
        withContext(Dispatchers.IO) { usuarioServiceImplementation.delete(email, rutinaid) }

    suspend fun insert(usuario: Usuario) =
        withContext(Dispatchers.IO) { usuarioServiceImplementation.insert(usuario.toUsuarioApi()) }
    suspend fun insertRutina(email : String, rutinaid : Int) =
        withContext(Dispatchers.IO) { usuarioServiceImplementation.insertRutina(email, rutinaid) }

    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
        usuarioServiceImplementation.update(usuario.toUsuarioApi())
    }

    suspend fun updateRutinaState(userid: String, rutinaState: Int) = withContext(Dispatchers.IO) {
        val usuario = usuarioServiceImplementation.get(userid).copy(rutinastate = rutinaState)
        usuarioServiceImplementation.update(usuario)
    }


}