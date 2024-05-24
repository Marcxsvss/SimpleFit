package com.simplefit.data

import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RutinaMaquinaRepository @Inject constructor(
    private val rutinaMaquinaDao: RutinaMaquinaDao
) {

    suspend fun get(rutinaid: Int, dia: String): List<Int> = //Devuelve los id de maquina para esa rutina ese dia
        withContext(Dispatchers.IO)
        {
            rutinaMaquinaDao.get(rutinaid, dia)
        }
}
