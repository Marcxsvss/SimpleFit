package com.simplefit.data

import com.simplefit.data.room.usuarioRutina.UsuarioRutinaDao
//import com.simplefit.data.services.usuariorutina.UsuarioRutinaServiceImplementation
import com.simplefit.models.UsuarioRutina
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRutinaRepository@Inject constructor(
    private val usuarioRutinaDao: UsuarioRutinaDao,
) {

    suspend fun deleteUserRoutines(userid: String) = withContext(Dispatchers.IO) {
    usuarioRutinaDao.deleteAllRutinas(userid)
    }

}


