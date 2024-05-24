package com.simplefit.data


import com.simplefit.data.services.consejo.ConsejosService
import com.simplefit.data.services.consejo.ConsejosServiceImplementation
import com.simplefit.models.Consejo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ConsejosRepository @Inject constructor(

    private val consejosServiceImplementation: ConsejosServiceImplementation
) {

    suspend fun get(): List<String> =
        withContext(Dispatchers.IO)
        {
            consejosServiceImplementation.get().map { it.consejo }.shuffled().take(5)
        }

}


