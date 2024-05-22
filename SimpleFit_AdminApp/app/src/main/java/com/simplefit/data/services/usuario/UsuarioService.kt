package com.simplefit.data.services.usuario

import com.simplefit.data.services.RespuestaApi
import com.simplefit.data.services.rutina.RutinasApi
import dagger.Provides
import retrofit2.Response
import retrofit2.http.*

interface UsuarioService {

    @GET("usuarios")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun usuarios(): Response<List<UsuarioApi>>
    @GET("usuarios/{email}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun usuario(@Path("email") email: String): Response<UsuarioApi>

    @POST("usuarios")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun insert(@Body u : UsuarioApi): Response<RespuestaApi>

    @PUT("usuarios")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun update(@Body u2 : UsuarioApi): Response<RespuestaApi>

    @DELETE("usuarios/delete/{email}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun delete(@Path("email") email: String): Response<RespuestaApi>
}