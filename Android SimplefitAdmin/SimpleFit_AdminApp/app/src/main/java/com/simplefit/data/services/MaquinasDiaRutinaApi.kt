package com.simplefit.data.services

import com.google.gson.annotations.SerializedName

data class MaquinasDiaRutinaApi(
    @SerializedName("tabla")
    val tabla: String,
    @SerializedName("consejos")
    val totalRegistros: List<Int>
)