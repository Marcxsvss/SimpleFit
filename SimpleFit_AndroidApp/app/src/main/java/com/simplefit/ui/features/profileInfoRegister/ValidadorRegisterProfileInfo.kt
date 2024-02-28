package com.simplefit.ui.features.profileInfoRegister

import com.pmdm.tienda.utilities.validacion.Validador
import com.pmdm.tienda.utilities.validacion.ValidadorCompuesto
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorCorreo
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorLongitudMinimaTexto
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorTextoNoVacio
import javax.inject.Inject

class ValidadorRegisterProfileInfo  @Inject constructor() : Validador<RegisterProfileInfoUiState> {
    var validadorEmail =
        ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("El email no puede estar vacío"))
            .add(ValidadorCorreo("El correo no es válido"))

    var validadorPassword =
        ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("La contraseña no puede estar vacía"))
            .add(ValidadorLongitudMinimaTexto(8, "la contraseña debe tener como mínimo 8 carácteres"))
    var validadorDni =
        ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("El DNI no puede estar vacío"))
            .add(ValidadorLongitudMinimaTexto(9, "El DNI debe tener como mínimo 9 carácteres"))

    override fun valida(datos: RegisterProfileInfoUiState): ValidacionRegisterProfileInfoUiState {
        val validacionLogin = validadorEmail.valida(datos.email)
        val validacionPassword = validadorPassword.valida(datos.password)
        val validacionDni = validadorDni.valida(datos.dni)

        return ValidacionRegisterProfileInfoUiState(
            validacionEmail = validacionLogin,
            validacionPassword = validacionPassword,
            validacionDni = validacionDni
        )
    }
}