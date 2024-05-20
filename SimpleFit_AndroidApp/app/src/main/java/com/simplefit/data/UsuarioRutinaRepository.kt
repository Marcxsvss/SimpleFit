package com.simplefit.data

import com.simplefit.data.room.usuarioRutina.UsuarioRutinaDao
//import com.simplefit.data.services.usuariorutina.UsuarioRutinaServiceImplementation
import com.simplefit.models.UsuarioRutina
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsuarioRutinaRepository@Inject constructor(
    private val usuarioRutinaDao: UsuarioRutinaDao,
    //private val usuarioRutinaServiceImplementation: UsuarioRutinaServiceImplementation
) {
//    suspend fun get(userid: String): List<UsuarioRutina> =
//        withContext(Dispatchers.IO)
//        {
//            usuarioRutinaServiceImplementation.get(userid).map { it.toUsuarioRutina() }
//        }
//    suspend fun insert(rutina: UsuarioRutina) = withContext(Dispatchers.IO) {
//        usuarioRutinaServiceImplementation.insert(rutina.toUsuarioRutinaApi())
//    }
//    suspend fun delete(userid: String, rutinaid: Int) = withContext(Dispatchers.IO) {
//        usuarioRutinaServiceImplementation.delete(userid, rutinaid)
//    }
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


