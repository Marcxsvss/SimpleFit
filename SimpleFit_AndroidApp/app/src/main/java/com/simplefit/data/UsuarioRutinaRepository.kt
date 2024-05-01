package com.simplefit.data

import com.simplefit.data.room.usuarioRutina.UsuarioRutinaDao
import com.simplefit.models.UsuarioRutina
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRutinaRepository@Inject constructor(private val usuarioRutinaDao: UsuarioRutinaDao) {
    suspend fun get(userid: String): List<UsuarioRutina> =
        withContext(Dispatchers.IO)
        {
            usuarioRutinaDao.get(userid).map { it.toUsuarioRutina() }
        }
    suspend fun insert(rutina: UsuarioRutina) = withContext(Dispatchers.IO) {
        usuarioRutinaDao.insert(rutina.toUsuarioRutinaEntity())
    }
    suspend fun delete(userid: String, rutinaid: Int) = withContext(Dispatchers.IO) {
        usuarioRutinaDao.deleteRutina(userid, rutinaid)
    }
}


