package com.simplefit.data.services

import retrofit2.Response
import retrofit2.http.*

interface UsuarioService {
//    @GET("usuarios")
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    suspend fun usuarios(): Response<List<UsuarioApi>>

    @GET("usuarios/{email}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun usuario(@Path("email") email: String): Response<UsuarioApi>

//    @GET("contactos/count")
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    suspend fun count(): Response<TotalRegistrosApi>

    @POST("usuario")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun insert(@Body u : UsuarioApi): Response<RespuestaApi>

    @PUT("usuarios/{email}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun update(@Body u1 : UsuarioApi, @Body u2 : UsuarioApi): Response<RespuestaApi>

    @DELETE("usuarios/{email}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun delete(@Path("id") email: String): Response<RespuestaApi>
}