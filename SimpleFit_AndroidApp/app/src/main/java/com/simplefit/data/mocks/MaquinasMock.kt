package com.simplefit.data.mocks

import java.sql.Blob

data class MaquinasMock(
    val maquinaid : Int,
    val nombre : String,
    val musculo : String,
    val imagen : String?,
    val descripcion : String
)
