package com.simplefit.data.services.consejo

//import android.util.Log
//import com.simplefit.data.services.ApiServicesException
//import com.simplefit.data.services.ListaConsejosApi
//import javax.inject.Inject
//
//class ConsejosServiceImplementation @Inject constructor(
//    private val consejosService: ConsejosService
//) {
//    private val logTag: String = "OkHttp"
//    suspend fun get(): ListaConsejosApi {
//        val mensajeError = "No se han podido obtener los consejos"
//        try {
//            val response = consejosService.consejos()
//            if (response.isSuccessful) {
//                Log.d(logTag, response.toString())
//                val dato = response.body()
//                return dato ?: throw ApiServicesException("No hay datos")
//            } else {
//                val body = response.errorBody()?.string()
//                Log.e(logTag, "$mensajeError (código ${response.code()}): $this\n${body}")
//                throw ApiServicesException(mensajeError)
//            }
//        } catch (e: Exception) {
//            Log.e(logTag, "Error: ${e.localizedMessage}")
//            throw ApiServicesException(mensajeError)
//        }
//    }
//
//}