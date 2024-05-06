package com.simplefit.data.services.rutina

import com.simplefit.data.services.RespuestaApi
import retrofit2.Response
import retrofit2.http.*

interface RutinasService {
    @GET("rutinas")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun rutinas(): Response<List<RutinasApi>>
    @GET("rutinas/{rutinaid}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun rutinas(@Path("rutinaid") rutinaid : Int): Response<RutinasApi>
    //Todavía no se como voy a hacer el get completo como hago con room
}