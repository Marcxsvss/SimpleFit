package com.simplefit.data

import com.simplefit.data.room.maquinas.MaquinasDao

//import com.simplefit.data.services.rutinamaquina.RutinaMaquinaServiceImplementation
//import com.simplefit.data.services.maquina.MaquinasServiceImplementation
import com.simplefit.models.Maquina
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MaquinasRepository @Inject constructor(
    private val maquinasDao: MaquinasDao,
    private val rutinaMaquinaRepository: RutinaMaquinaRepository,
    //private val maquinasServiceImplementation: MaquinasServiceImplementation,
//    private val rutinaMaquinaServiceImplementation: RutinaMaquinaServiceImplementation

) {
    suspend fun get(rutinaid: Int, dia: String): List<Maquina> =
        withContext(Dispatchers.IO)
        {
            maquinasDao.get().filter { it.maquinaid in rutinaMaquinaRepository.get(rutinaid, dia) }
        }
//    suspend fun get(rutinaid: Int, dia: String): List<Maquina> =
//        withContext(Dispatchers.IO)
//        {
//            maquinasServiceImplementation.get().filter{ it.maquinaid in rutinaMaquinaServiceImplementation.get(rutinaid, dia).totalRegistros }.map { it.toMaquina() }
//
//           // maquinasServiceImplementation.get().filter { it.maquinaid in rutinaMaquinaServiceImplementation.get(rutinaid, dia) }
//        }
//        suspend fun get(rutinaid: Int, dia: String): List<Maquina> =
//        withContext(Dispatchers.IO)
//        {
//            maquinasServiceImplementation.get().filter { it.maquinaid in rutinaMaquinaRepository.get(rutinaid, dia) }.map { it.toMaquina() }
//        }

}




