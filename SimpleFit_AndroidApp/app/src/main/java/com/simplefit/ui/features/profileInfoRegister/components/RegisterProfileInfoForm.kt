package com.simplefit.ui.features.profileInfoRegister.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    PesoState : Int,
    validacionPeso: Validacion,
    onValueChangeEdad: (Int) -> Unit,
    onValueChangeSexo: (String) -> Unit,
    onValueChangeSomatotipo: (String) -> Unit,
    onValueChangeAlergia: (String) -> Unit,
    onValueChangeAltura: (Int) -> Unit,
    onValueChangePeso: (Int) -> Unit,
    onClickGuardar: () -> Unit
) {
    Column {

        //Faltan los 2 OutlinedTextField

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
            onValueChange = onValueChangeSexo
        )
        ExposedDropdownMenuBoxAlergia(
            modifier = modifier,
            //sexoState = sexoState,
            onValueChange = onValueChangeSexo
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
