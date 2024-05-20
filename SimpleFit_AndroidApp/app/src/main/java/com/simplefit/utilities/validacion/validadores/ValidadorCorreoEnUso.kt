package com.simplefit.utilities.validacion.validadores

import com.pmdm.tienda.utilities.validacion.Validacion
import com.pmdm.tienda.utilities.validacion.Validador
import com.simplefit.data.UsuarioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//class ValidadorCorreoEnUso(
//    val error: String = "Correo en uso",
//
//) : Validador<String> {
//    override fun valida(texto: String): Validacion {
//        return object : Validacion {
//            override val hayError: Boolean
//
//                get() = texto = ""
//
//            override val mensajeError: String
//                get() = error
//        }
//    }
//}