//package com.simplefit.data.services.maquina
//
//import android.util.Log
//import com.simplefit.data.services.ApiServicesException
//import javax.inject.Inject
//
//class MaquinasServiceImplementation @Inject constructor(
//    private val maquinaService: MaquinaService
//) {
//    private val logTag: String = "OkHttp"
//    suspend fun get(): List<MaquinasApi> {
//        val mensajeError = "No se han podido obtener la lista de maquinas"
//        try {
//            val response = maquinaService.maquinas()
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