package com.simplefit.data

import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RutinasRepository(private val rutinasDao: RutinasDao) {


    suspend fun get(id: Int): Rutinas? =
        withContext(Dispatchers.IO) { rutinasDao.get() }

    suspend fun insert(rutina: Rutinas) =
        withContext(Dispatchers.IO) { rutinasDao.insert(rutina.toUsuarioEntity()) }

    suspend fun update(usuario: Usuario) = withContext(Dispatchers.IO) {
        rutinasDao.update(usuario.toUsuarioEntity())
    }
//    suspend fun delete(email: String) = withContext(Dispatchers.IO) {
//        usuarioService.delete(email)
//    }

}