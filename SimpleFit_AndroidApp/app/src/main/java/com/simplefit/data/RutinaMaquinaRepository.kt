package com.simplefit.data

import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaDao
import com.simplefit.data.services.maquina.MaquinasServiceImplementation
import com.simplefit.data.services.rutinamaquina.RutinaMaquinaServiceImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RutinaMaquinaRepository @Inject constructor(
    private val rutinaMaquinaDao: RutinaMaquinaDao,
    private val rutinaMaquinasServiceImplementation: RutinaMaquinaServiceImplementation
) {
    suspend fun get(rutinaid: Int, dia: String): List<Int> = //Devuelve los id de maquina para esa rutina ese dia
        withContext(Dispatchers.IO)
        {
            rutinaMaquinasServiceImplementation.get(rutinaid, dia).totalRegistros
        }
}
