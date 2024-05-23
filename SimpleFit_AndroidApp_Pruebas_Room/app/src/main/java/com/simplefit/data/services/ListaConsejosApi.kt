package com.simplefit.data.services

import com.google.gson.annotations.SerializedName

data class ListaConsejosApi(
    @SerializedName("tabla")
    val tabla: String,
    @SerializedName("consejos")
    val totalRegistros: List<String>
)