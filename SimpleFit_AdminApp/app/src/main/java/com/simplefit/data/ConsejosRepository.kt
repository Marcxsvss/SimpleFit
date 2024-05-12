package com.simplefit.data

import com.simplefit.data.room.consejos.ConsejosDao
import com.simplefit.data.services.consejo.ConsejosService
import com.simplefit.data.services.consejo.ConsejosServiceImplementation
import com.simplefit.models.Consejo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ConsejosRepository @Inject constructor(
    private val consejosDao: ConsejosDao,
    private val consejosServiceImplementation: ConsejosServiceImplementation
) {
    //    suspend fun get() : List<String> =
//        withContext(Dispatchers.IO)
//        {
//            consejosDao.get().shuffled().take(5)
//        }
    suspend fun get(): List<String> =
        withContext(Dispatchers.IO)
        {
            consejosServiceImplementation.get().totalRegistros.shuffled().take(5)
        }

}


