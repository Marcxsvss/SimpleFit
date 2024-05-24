package com.simplefit.data.services.rutinamaquina

import com.simplefit.data.services.MaquinasDiaRutinaApi
import com.simplefit.data.services.RespuestaApi
import retrofit2.Response
import retrofit2.http.*

interface RutinaMaquinaService {
    @GET("rutinamaquina/{rutinaid}/{dia}")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun rutinaMaquina(@Path("rutinaid") rutinaid: Int,@Path("dia") dia: String): Response<List<Int>>


}