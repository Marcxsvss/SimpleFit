package com.simplefit.ui.features.userAuthentication.profileInfoRegister

import android.util.Range
import com.pmdm.tienda.utilities.validacion.Validador
import com.pmdm.tienda.utilities.validacion.ValidadorCompuesto
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorCorreo
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorLongitudMinimaTexto
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorNumeroEntero
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorTextoNoVacio
import com.simplefit.utilities.validacion.validadores.ValidadorAltura
import com.simplefit.utilities.validacion.validadores.ValidadorPeso
import javax.inject.Inject

class ValidadorRegisterProfileInfo  @Inject constructor() : Validador<RegisterProfileInfoUiState> {

    var validadorPeso =
        ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("El peso no puede estar vacío"))
            .add(ValidadorNumeroEntero(rango = Range(15, 300),error = "El peso debe estar entre 15 y 300 kg"))
    var validadorAltura = ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("La altura no puede estar vacía"))
            .add(ValidadorNumeroEntero(Range(0, 300),error = "La altura debe estar entre 0 y 300 cm"))


    override fun valida(datos: RegisterProfileInfoUiState): ValidacionRegisterProfileInfoUiState {
        val validacionPeso = validadorPeso.valida(datos.peso.toString())
        val validacionAltura = validadorAltura.valida(datos.altura.toString())

        return ValidacionRegisterProfileInfoUiState(
            validacionPeso = validacionPeso,
            validacionAltura = validacionAltura
        )
    }
}