package com.simplefit.ui.features.profileInfoRegister

import com.pmdm.tienda.utilities.validacion.Validacion
import com.pmdm.tienda.utilities.validacion.ValidacionCompuesta

data class ValidacionRegisterProfileInfoUiState(
    val validacionEmail: Validacion = object : Validacion {},
    val validacionPassword: Validacion = object : Validacion {},
    val validacionDni: Validacion = object : Validacion {}
) : Validacion {
    private lateinit var validacionCompuesta: ValidacionCompuesta

    private fun componerValidacion(): ValidacionCompuesta {
        validacionCompuesta = ValidacionCompuesta()
            .add(validacionEmail)
            .add(validacionPassword)
            .add(validacionDni)
        return validacionCompuesta
    }

    override val hayError: Boolean
        get() = componerValidacion().hayError
    override val mensajeError: String?
        get() = validacionCompuesta.mensajeError
}