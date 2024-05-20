package com.simplefit.ui.features.userAuthentication.accountInfoRegister

import com.pmdm.tienda.utilities.validacion.Validador
import com.pmdm.tienda.utilities.validacion.ValidadorCompuesto
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorCorreo
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorLongitudMinimaTexto
import com.pmdm.tienda.utilities.validacion.validadores.ValidadorTextoNoVacio
import com.simplefit.data.UsuarioRepository
//import com.simplefit.utilities.validacion.validadores.ValidadorCorreoEnUso
import javax.inject.Inject

class ValidadorRegisterAccountInfo  @Inject constructor() : Validador<RegisterAccountInfoUiState> {
    var validadorEmail =
        ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("El email no puede estar vacío"))
            //.add(ValidadorCorreoEnUso("El correo ya esta en uso"))
            .add(ValidadorCorreo("El correo no es válido"))


    var validadorPassword =
        ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("La contraseña no puede estar vacía"))
            .add(ValidadorLongitudMinimaTexto(8, "la contraseña debe tener como mínimo 8 carácteres"))
    var validadorNombre =
        ValidadorCompuesto<String>()
            .add(ValidadorTextoNoVacio("El nombre no puede estar vacío"))

    override fun valida(datos: RegisterAccountInfoUiState): ValidacionRegisterAccountInfoUiState {
        val validacionLogin = validadorEmail.valida(datos.email)
        val validacionPassword = validadorPassword.valida(datos.password)


        return ValidacionRegisterAccountInfoUiState(
            validacionEmail = validacionLogin,
            validacionPassword = validacionPassword,

        )
    }
}