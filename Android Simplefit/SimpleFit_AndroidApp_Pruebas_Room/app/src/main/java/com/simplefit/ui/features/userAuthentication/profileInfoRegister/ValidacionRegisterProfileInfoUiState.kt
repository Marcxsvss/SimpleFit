package com.simplefit.ui.features.userAuthentication.profileInfoRegister

import com.pmdm.tienda.utilities.validacion.Validacion
import com.pmdm.tienda.utilities.validacion.ValidacionCompuesta

data class ValidacionRegisterProfileInfoUiState(
    val validacionAltura: Validacion = object : Validacion {},
    val validacionPeso: Validacion = object : Validacion {},
) : Validacion {
    private lateinit var validacionCompuesta: ValidacionCompuesta

    private fun componerValidacion(): ValidacionCompuesta {
        validacionCompuesta = ValidacionCompuesta()
            .add(validacionAltura)
            .add(validacionPeso)
        return validacionCompuesta
    }

    override val hayError: Boolean
        get() = componerValidacion().hayError
    override val mensajeError: String?
        get() = validacionCompuesta.mensajeError
}