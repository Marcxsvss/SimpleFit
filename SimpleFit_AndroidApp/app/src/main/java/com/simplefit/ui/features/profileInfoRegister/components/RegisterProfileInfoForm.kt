package com.simplefit.ui.features.profileInfoRegister.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.recetas.ui.composables.OutlinedTextFieldNombre
import com.pmdm.tienda.utilities.validacion.Validacion
import com.simplefit.ui.composables.ExposedDropdownMenuBoxEdad
import com.simplefit.ui.theme.SimpleFitTheme

@Composable
fun RegisterProfileInfoForm(
    modifier: Modifier,
    nombreState: String,
    validacionNombre: Validacion,
    edadState: Int,
    sexoState : String,
    onValueChangeNombre: (String) -> Unit,
    onValueChangeEdad: (String) -> Unit,
    onValueChangeSexo: (String) -> Unit,
    onClickGuardar: () -> Unit
) {
    Column {//Crear todos los Outlined correspondientes a cada dato, estos están mal, hay que cambiarlos¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡
        //¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡
        OutlinedTextFieldNombre(
            modifier = modifier,
            label = "Nombre",
            nombreState = nombreState,
            validacionState = validacionNombre,
            onValueChange = onValueChangeNombre
        )

        /*ExposedDropdownMenuBoxEdad(
            modifier = modifier,
            edadState = edadState,
            onValueChange = onValueChangeEdad
        )
        ExposedDropdownMenuBoxSexo(
            modifier = modifier,
            label = "Sexo",
            sexoState = sexoState,
            validacionState = validacionSexo,
            onValueChange = onValueChangeSexo
        )*/




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
