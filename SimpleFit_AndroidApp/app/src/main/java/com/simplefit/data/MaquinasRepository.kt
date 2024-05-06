package com.simplefit.data

import com.simplefit.data.room.maquinas.MaquinasDao
import com.simplefit.models.Maquina
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MaquinasRepository @Inject constructor(
    private val maquinasDao: MaquinasDao,
    private val rutinaMaquinaRepository: RutinaMaquinaRepository
) {
    suspend fun get(rutinaid: Int, dia: String): List<Maquina> =
        withContext(Dispatchers.IO)
        {
            maquinasDao.get().filter { it.maquinaid in rutinaMaquinaRepository.get(rutinaid, dia) }
        }

}




