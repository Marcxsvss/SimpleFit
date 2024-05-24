package com.simplefit.data.services.usuariorutina

import com.simplefit.data.services.RespuestaApi
import retrofit2.Response
import retrofit2.http.*

interface UsuarioRutinaService {
    @GET("usuariorutina/{userid}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun usuarioRutina(@Path("userid") userid: String): Response<List<UsuarioRutinaApi>>

    @POST("usuariorutina")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun insert(@Body u : UsuarioRutinaApi): Response<RespuestaApi>

    @DELETE("usuariorutina/{userid}/{rutinaid}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun delete(@Path("userid") userid: String,@Path("rutinaid") rutinaid: Int): Response<RespuestaApi>
}