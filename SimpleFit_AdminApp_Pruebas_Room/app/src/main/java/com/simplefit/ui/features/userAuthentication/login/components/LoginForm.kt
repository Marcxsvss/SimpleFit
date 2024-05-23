package com.pmdm.tienda.ui.features.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.recetas.ui.composables.CheckboxWithText
import com.pmdm.recetas.ui.composables.OutlinedTextFieldEmail
import com.pmdm.recetas.ui.composables.OutlinedTextFieldPassword
import com.pmdm.tienda.utilities.validacion.Validacion
import com.simplefit.ui.theme.SimpleFitTheme


@Composable
fun LoginForm(
    modifier: Modifier,
    loginState: String,
    validacionLogin: Validacion,
    passwordState: String,
    validacionPassword: Validacion,
    onValueChangeLogin: (String) -> Unit,
    onValueChangePassword: (String) -> Unit,
    onClickLogearse: () -> Unit
) {
    Column {
        OutlinedTextFieldEmail(
            modifier = modifier,
            label = "Login",
            emailState = loginState,
            validacionState = validacionLogin,
            onValueChange = onValueChangeLogin
        )

        OutlinedTextFieldPassword(
            modifier = modifier,
            label = "Password",
            passwordState = passwordState,
            validacionState = validacionPassword,
            onValueChange = onValueChangePassword
        )
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDAB338)),
            onClick = onClickLogearse,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}
