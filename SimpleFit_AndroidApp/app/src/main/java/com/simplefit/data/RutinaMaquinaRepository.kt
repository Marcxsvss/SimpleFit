package com.simplefit.data

import com.simplefit.data.room.maquinas.MaquinasDao
import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaDao
import com.simplefit.models.RutinaMaquina
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RutinaMaquinaRepository @Inject constructor(private val rutinaMaquinaDao: RutinaMaquinaDao) {
    suspend fun get(rutinaid: Int, dia: String): List<Int> =
        withContext(Dispatchers.IO)
        {
            rutinaMaquinaDao.get(rutinaid, dia)
        }


//    suspend fun insert(rutina: Rutinas) =
//        withContext(Dispatchers.IO) { rutinasDao.insert(rutina.toRutinasEntity()) }
//
//    suspend fun update(rutina: Rutinas) = withContext(Dispatchers.IO) {
//        rutinasDao.update(rutina.toRutinasEntity())
//    }
//    suspend fun delete(rutinaid: Int) = withContext(Dispatchers.IO) {
//        rutinasDao.delete(rutinaid)
//    }
}
