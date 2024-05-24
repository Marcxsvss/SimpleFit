package com.simplefit.data.services.rutina

import android.util.Log
import com.simplefit.data.services.ApiServicesException
import javax.inject.Inject

class RutinasServiceImplementation @Inject constructor(
    private val rutinasService: RutinasService
) {
    private val logTag: String = "OkHttp"
    suspend fun get(): List<RutinasApi> {
        val mensajeError = "No se han podido obtener la lista de rutinas"
        try {
            val response = rutinasService.rutinas()
            if (response.isSuccessful) {
                Log.d(logTag, response.toString())
                val dato = response.body()
                return dato ?: throw ApiServicesException("No hay datos")
            } else {
                val body = response.errorBody()?.string()
                Log.e(logTag, "$mensajeError (código ${response.code()}): $this\n${body}")
                throw ApiServicesException(mensajeError)
            }
        } catch (e: Exception) {
            Log.e(logTag, "Error: ${e.localizedMessage}")
            throw ApiServicesException(mensajeError)
        }
    }
    suspend fun get(rutinaid : Int?): RutinasApi {
        val mensajeError = "No se han podido obtener la rutina con id = $rutinaid"
        try {
            val response = rutinasService.rutina(rutinaid)
            if (response.isSuccessful) {
                Log.d(logTag, response.toString())
                val dato = response.body()
                return dato ?: throw ApiServicesException("No hay datos")
            } else {
                val body = response.errorBody()?.string()
                Log.e(logTag, "$mensajeError (código ${response.code()}): $this\n${body}")
                throw ApiServicesException(mensajeError)
            }
        } catch (e: Exception) {
            Log.e(logTag, "Error: ${e.localizedMessage}")
            throw ApiServicesException(mensajeError)
        }
    }


}