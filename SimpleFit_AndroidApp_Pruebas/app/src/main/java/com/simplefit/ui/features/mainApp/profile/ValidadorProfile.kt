package com.simplefit.ui.features.mainApp.profile

import android.util.Range
import com.pmdm.tienda.utilities.validacion.Validador
import com.pmdm.tienda.utilities.validacion.ValidadorCompuesto
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorNumeroEntero
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorTextoNoVacio
import javax.inject.Inject

class ValidadorProfile  @Inject constructor() : Validador<ProfileUiState> {

    var validadorPeso =
        ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("El peso no puede estar vacío"))
            .add(ValidadorNumeroEntero(rango = Range(35, 150),error = "El peso debe estar entre 35 y 150 kg"))
    var validadorAltura = ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("La altura no puede estar vacía"))
            .add(ValidadorNumeroEntero(Range(140, 220),error = "La altura debe estar entre 140 y 220 cm"))


    override fun valida(datos: ProfileUiState): ValidacionProfileUiState {
        val validacionPeso = validadorPeso.valida(datos.peso.toString())
        val validacionAltura = validadorAltura.valida(datos.altura.toString())

        return ValidacionProfileUiState(
            validacionPeso = validacionPeso,
            validacionAltura = validacionAltura
        )
    }
}