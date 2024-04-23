package com.simplefit.data

import com.simplefit.data.room.maquinas.MaquinasDao
import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.models.Maquina
import com.simplefit.models.Rutinas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MaquinasRepository @Inject constructor(
    private val maquinasDao: MaquinasDao,
    private val rutinaMaquinaRepository: RutinaMaquinaRepository
) {
    suspend fun get(rutinaid: Int, dia: String) : List<Maquina> =
        withContext(Dispatchers.IO)
        {
            maquinasDao.get().filter { it.maquinaid in rutinaMaquinaRepository.get(rutinaid, dia) }
        }


suspend fun get(maquinaid : Int) : Maquina =
    withContext(Dispatchers.IO)
    {
        maquinasDao.get(maquinaid)
    }


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



