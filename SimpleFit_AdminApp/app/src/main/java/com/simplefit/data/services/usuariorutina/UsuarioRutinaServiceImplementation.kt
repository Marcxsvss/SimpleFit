package com.simplefit.data.services.usuariorutina

import android.util.Log
import com.simplefit.data.services.ApiServicesException
import javax.inject.Inject

class UsuarioRutinaServiceImplementation @Inject constructor(
    private val usuarioRutinaService: UsuarioRutinaService
) {
    private val logTag: String = "OkHttp"
    suspend fun get(email: String): List<UsuarioRutinaApi> {
        val mensajeError = "No se han podido obtener el usuario con email = $email"
        try {
            val response = usuarioRutinaService.usuarioRutina(email)
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
    suspend fun insert(usuario: UsuarioRutinaApi) {
        val mensajeError ="No se ha podido añadir el usuario"
        try {
            val response = usuarioRutinaService.insert(usuario)
            if (response.isSuccessful) {
                Log.d(logTag, response.toString())
                // Aquí response.body() es un objeto de tipo RespuestaApi
                // que simplemente logeamos si no es null.
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


    suspend fun deleteRoutinesFromUsers(rutinaid: Int) {
        val mensajeError = "No se han podido borrar la relacion del usuario con las rutinas"
        try {
            val response = usuarioRutinaService.deleteRoutinesFromUsers(rutinaid)
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