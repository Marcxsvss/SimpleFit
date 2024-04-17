package com.simplefit.ui.features.userAuthentication.accountInfoRegister.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.recetas.ui.composables.OutlinedTextFieldDni
import com.pmdm.recetas.ui.composables.OutlinedTextFieldEmail
import com.pmdm.recetas.ui.composables.OutlinedTextFieldNombre
import com.pmdm.recetas.ui.composables.OutlinedTextFieldPassword
import com.pmdm.tienda.utilities.validacion.Validacion
import com.simplefit.R
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
    nombreState : String,
    validacionNombre: Validacion,
    onValueChangeEmail: (String) -> Unit,
    onValueChangePassword: (String) -> Unit,
    onValueChangeDni: (String) -> Unit,
    onValueChangeNombre : (String) -> Unit,
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
        Text(
            text = "PASSWORD",
            color = Color(0xFFDAB338),
            fontSize = 20.sp,
            fontFamily = FontFamily(
                Font(resId = R.font.bayon_regular)
            )
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
        OutlinedTextFieldNombre(
            modifier = modifier,
            label = "Nombre",
            nombreState = nombreState,
            validacionState = validacionNombre,
            onValueChange = onValueChangeNombre
        )



        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDAB338)),
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
    var nombreState by remember{ mutableStateOf("")}
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
            nombreState = nombreState,
            validacionNombre = object : Validacion {},
            onValueChangeEmail = { emailState = it },
            onValueChangePassword = { passwordState = it },
            onValueChangeDni = { dniState = it },
            onValueChangeNombre = { nombreState = it },
            onClickRegistrarse = {}
        )
    }
}
