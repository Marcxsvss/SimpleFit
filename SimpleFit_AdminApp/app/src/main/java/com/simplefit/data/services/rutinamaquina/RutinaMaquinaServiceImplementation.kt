package com.simplefit.data.services.rutinamaquina

import android.util.Log
import com.simplefit.data.services.ApiServicesException
import com.simplefit.data.services.MaquinasDiaRutinaApi
import javax.inject.Inject

class RutinaMaquinaServiceImplementation @Inject constructor(
    private val rutinaMaquinaService: RutinaMaquinaService
) {
    private val logTag: String = "OkHttp"
    suspend fun get(rutinaid : Int,dia: String): MaquinasDiaRutinaApi {
        val mensajeError = "No se han podido obtener la rutina con id = $rutinaid y dia = $dia"
        try {
            val response = rutinaMaquinaService.rutinaMaquina(rutinaid,dia)
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
    suspend fun delete(rutinaidid: Int) {
        val mensajeError = "No se han podido borrar las maquinas asociadas a la rutina"
        try {
            val response = rutinaMaquinaService.delete(rutinaidid)
            if (response.isSuccessful) {
                Log.d(logTag, response.toString())
                Log.d(logTag, response.body()?.toString() ?: "No hay respuesta")
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