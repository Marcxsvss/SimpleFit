package com.simplefit.data.services.maquina

import com.simplefit.data.services.RespuestaApi
import retrofit2.Response
import retrofit2.http.*

interface MaquinaService {
    @GET("maquinas")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun maquinas(): Response<List<MaquinasApi>>
}