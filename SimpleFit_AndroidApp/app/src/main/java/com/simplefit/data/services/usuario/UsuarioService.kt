package com.simplefit.data.services.usuario

import com.simplefit.data.services.RespuestaApi
import com.simplefit.data.services.rutina.RutinasApi
import retrofit2.Response
import retrofit2.http.*

interface UsuarioService {


    @GET("usuarios/{email}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun usuario(@Path("email") email: String): Response<UsuarioApi>
    @GET("usuarios/{email}/registro")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun comprobar(@Path("email") email: String): Response<UsuarioApi>
    @GET("usuarios/{email}/rutinas")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun rutinas(@Path("email") email: String): Response<List<RutinasApi>>

    @POST("usuarios")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun insert(@Body u : UsuarioApi): Response<RespuestaApi>

    @POST("usuarios/post/{email}/{rutinaid}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun insertRutina(@Path("email") email: String,@Path("rutinaid") rutinaid: Int): Response<RespuestaApi>
    @PUT("usuarios")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun update(@Body u2 : UsuarioApi): Response<RespuestaApi>

    @DELETE("usuarios/delete/{email}/{rutinaid}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun delete(@Path("email") email: String,@Path("rutinaid") rutinaid: Int): Response<RespuestaApi>
}