package com.simplefit.utilities.validacion.validadores

import com.pmdm.tienda.utilities.validacion.Validacion
import com.pmdm.tienda.utilities.validacion.Validador

class ValidadorAltura(
    val error: String
) : Validador<String> {
    override fun valida(datos: String): Validacion {
        return object : Validacion {
            override val hayError: Boolean
                get() = datos.toInt() in 140..220 //El problema esta en que si mete una letra rompe al pasar a int
            override val mensajeError: String
                get() = error
        }
    }
}