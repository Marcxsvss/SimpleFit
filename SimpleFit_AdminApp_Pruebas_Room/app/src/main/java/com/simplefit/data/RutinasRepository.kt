package com.simplefit.data

import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.usuario.UsuarioDao

import com.simplefit.models.Rutinas

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RutinasRepository @Inject constructor(
    private val rutinasDao: RutinasDao,

) {

    suspend fun get(): List<Rutinas> = withContext(Dispatchers.IO)
    {
        rutinasDao.get().map { it.toRutina() }
    }
    suspend fun delete(rutinaid : Int) = withContext(Dispatchers.IO)
    {
        rutinasDao.delete(rutinaid)
    }


}