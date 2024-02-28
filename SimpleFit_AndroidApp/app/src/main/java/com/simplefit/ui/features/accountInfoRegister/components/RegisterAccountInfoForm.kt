package com.simplefit.ui.features.accountInfoRegister.components

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
import com.pmdm.recetas.ui.composables.OutlinedTextFieldDni
import com.pmdm.recetas.ui.composables.OutlinedTextFieldEmail
import com.pmdm.recetas.ui.composables.OutlinedTextFieldPassword
import com.pmdm.tienda.utilities.validacion.Validacion
import com.simplefit.ui.theme.SimpleFitTheme

@Composable
fun RegisterAccountInfoForm(
    modifier: Modifier,
    emailState: String,
    validacionEmail: Validacion,
    passwordState: String,
    validacionPassword: Validacion,
    dniState : String,
    validacionDni: Validacion,
    onValueChangeEmail: (String) -> Unit,
    onValueChangePassword: (String) -> Unit,
    onValueChangeDni: (String) -> Unit,
    onClickRegistrarse: () -> Unit
) {
    Column {
        OutlinedTextFieldEmail(
            modifier = modifier,
            label = "Email",
            emailState = emailState,
            validacionState = validacionEmail,
            onValueChange = onValueChangeEmail
        )

        OutlinedTextFieldPassword(
            modifier = modifier,
            label = "Contraseña",
            passwordState = passwordState,
            validacionState = validacionPassword,
            onValueChange = onValueChangePassword
        )
        OutlinedTextFieldPassword(
            modifier = modifier,
            label = "Repite Contraseña",
            passwordState = passwordState,
            validacionState = validacionPassword,
            onValueChange = onValueChangePassword
        )
        OutlinedTextFieldDni(
            modifier = modifier,
            label = "DNI",
            dniState = dniState,
            validacionState = validacionDni,
            onValueChange = onValueChangeDni
        )



        Button(
            onClick = onClickRegistrarse,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Sign Up")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegisterFormTest() {

    var emailState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }
    var dniState by remember { mutableStateOf("") }
    var recordarme by remember { mutableStateOf(false) }

    SimpleFitTheme {
        RegisterAccountInfoForm(
            modifier = Modifier.fillMaxWidth(),
            emailState = emailState,
            validacionEmail = object : Validacion {},
            passwordState = passwordState,
            dniState = dniState,
            validacionDni = object : Validacion {},
            validacionPassword = object : Validacion {},
            onValueChangeEmail = { emailState = it },
            onValueChangePassword = { passwordState = it },
            onValueChangeDni = { dniState = it },
            onClickRegistrarse = {}
        )
    }
}
