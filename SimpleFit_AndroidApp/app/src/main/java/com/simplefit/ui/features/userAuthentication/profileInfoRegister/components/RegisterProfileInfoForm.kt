package com.simplefit.ui.features.userAuthentication.profileInfoRegister.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pmdm.recetas.ui.composables.OutlinedTextFieldAltura
import com.pmdm.recetas.ui.composables.OutlinedTextFieldPeso
import com.pmdm.tienda.utilities.validacion.Validacion
import com.simplefit.ui.composables.ExposedDropdownMenuBoxAlergia
import com.simplefit.ui.composables.ExposedDropdownMenuBoxEdad
import com.simplefit.ui.composables.ExposedDropdownMenuBoxSexo
import com.simplefit.ui.composables.ExposedDropdownMenuBoxSomatotipo

@Composable
fun RegisterProfileInfoForm(
    modifier: Modifier,
    edadState: Int,
    sexoState : String,
    somatotipoState : String,
    alergiaState : String,
    alturaState : Int,
    validacionAltura: Validacion,
    pesoState : Int,
    validacionPeso: Validacion,
    onValueChangeEdad: (Int) -> Unit,
    onValueChangeSexo: (String) -> Unit,
    onValueChangeSomatotipo: (String) -> Unit,
    onValueChangeAlergia: (String) -> Unit,
    onValueChangeAltura: (String) -> Unit,
    onValueChangePeso: (String) -> Unit,
    onClickGuardar: () -> Unit
) {
    Column {


        OutlinedTextFieldAltura(
            alturaState = alturaState.toString(),
            validacionState = validacionAltura,
            onValueChange = onValueChangeAltura)
        OutlinedTextFieldPeso(
            pesoState = pesoState.toString(),
            validacionState = validacionPeso,
            onValueChange = onValueChangePeso)

        ExposedDropdownMenuBoxEdad(
            modifier = modifier,
            //edadState = edadState,
            onValueChange = onValueChangeEdad
        )
        ExposedDropdownMenuBoxSexo(
            modifier = modifier,
            //sexoState = sexoState,
            onValueChange = onValueChangeSexo
        )
        ExposedDropdownMenuBoxSomatotipo(
            modifier = modifier,
            //sexoState = sexoState,
            onValueChange = onValueChangeSomatotipo
        )
        ExposedDropdownMenuBoxAlergia(
            modifier = modifier,
            //sexoState = sexoState,
            onValueChange = onValueChangeAlergia
        )




        Button(
            onClick = onClickGuardar,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Sign Up")
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun RegisterFormTest() {
//
//    var nombreState by remember { mutableStateOf("") }
//    var edadState by remember { mutableStateOf(0) }
//    var sexoState by remember { mutableStateOf("") }
//    var recordarme by remember { mutableStateOf(false) }
//
//    SimpleFitTheme {
//        RegisterProfileInfoForm(
//            modifier = Modifier.fillMaxWidth(),
//            nombreState = nombreState,
//            validacionNombre = object : Validacion {},
//            edadState = edadState,
//            sexoState = sexoState,
//            validacionDni = object : Validacion {},
//            validacionPassword = object : Validacion {},
//            onValueChangeEmail = { emailState = it },
//            onValueChangePassword = { passwordState = it },
//            onValueChangeDni = { dniState = it },
//            onClickRegistrarse = {}
//        )
//    }
//}
