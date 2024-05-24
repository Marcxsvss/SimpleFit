package com.pmdm.recetas.ui.composables

import android.telephony.PhoneNumberUtils
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.AccessibilityNew
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.tienda.utilities.validacion.Validacion
import com.simplefit.R


@Composable
fun TextFieldWithErrorState(
    modifier: Modifier = Modifier,
    label: String,
    textoState: String,
    textoPista: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    validacionState: Validacion,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = textoState,
        onValueChange = onValueChange,
        singleLine = true,
        leadingIcon = leadingIcon,
        placeholder = {
            Text(
                text = textoPista,
                style = TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f))
            )
        },
        label = { Text(if (validacionState.hayError) "${label}*" else label) },
        keyboardOptions = keyboardOptions,
        supportingText = {
            if (validacionState.hayError) {
                Text(text = validacionState.mensajeError!!)
            }
        },
        isError = validacionState.hayError,
        keyboardActions = keyboardActions
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldWithErrorState(
    modifier: Modifier = Modifier,
    label: String,
    textoState: String ,
    enabled:Boolean=true,
    textoPista: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    validacionState: Validacion,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit
) {
    Box()
    {
        Column()
        {
            Text(
                text = label,
                color = Color(0xFFDAB338),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(resId = R.font.bayon_regular)
                )
            )

            OutlinedTextField(
                modifier = modifier,
                value = textoState,
                enabled=enabled,
                onValueChange = onValueChange,
                singleLine = true,
                leadingIcon = leadingIcon,
                placeholder = {
                    Text(
                        text = textoPista,
                        style = TextStyle(color = Color(0xFFDAB338))
                    )
                },
                keyboardOptions = keyboardOptions,
                supportingText = {
                    if (validacionState.hayError) {
                        Text(text = validacionState.mensajeError!!)
                    }
                },
                isError = validacionState.hayError,
                keyboardActions = keyboardActions,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFDAB338),
                    unfocusedBorderColor = Color(0xFFDAB338),
                    disabledBorderColor = Color.Gray,
                    errorBorderColor = Color.Red,
                    focusedLabelColor = Color(0xFFDAB338)
                )
            )
        }

    }

}


@Composable
fun OutlinedTextFieldPassword(
    modifier: Modifier = Modifier,
    passwordState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit,
    label: String = "Clave",
    labelShow: String = "Muestra clave",
    labelHide: String = "Oculta clave",
    iconoInformativo: Painter = rememberVectorPainter(image = Icons.Filled.Lock),
) {
    var passwordHidden by remember { mutableStateOf(true) }
    OutlinedTextField(
        modifier = modifier,
        value = passwordState,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(if (validacionState.hayError) "${label}*" else label) },
        supportingText = {
            if (validacionState.hayError) {
                Text(text = validacionState.mensajeError!!)
            }
        },
        isError = validacionState.hayError,
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(
                painter = iconoInformativo,
                contentDescription = label
            )
        },
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordHidden) labelShow else labelHide
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFDAB338),
            unfocusedBorderColor = Color(0xFFDAB338),
            disabledBorderColor = Color.Gray,
            errorBorderColor = Color.Red,
            focusedLabelColor = Color(0xFFDAB338)
        )
    )
}


@Composable
fun OutlinedTextFieldPhone(
    modifier: Modifier = Modifier,
    label: String = "Teléfono",
    telefonoState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
) {
    OutlinedTextFieldWithErrorState(
        modifier = modifier,
        label = label,
        textoState = telefonoState,
        textoPista = "999999999",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "Teléfono"
            )
        },
        validacionState = validacionState,
        onValueChange = {
            var text = it
            if (!validacionState.hayError) {
                try {
                    text = PhoneNumberUtils.formatNumber(it, "ES")
                } catch (e: Exception) {

                }
            }
            onValueChange(text)
        }
    )
}


@Composable
fun OutlinedTextFieldEmail(
    modifier: Modifier = Modifier,
    enabled: Boolean=true,
    label: String = "Email",
    emailState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
) {
    OutlinedTextFieldWithErrorState(
        modifier = modifier,
        label = label,
        enabled=enabled,
        textoState = emailState,
        textoPista = "ejemplo@correo.com",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email"
            )
        },
        validacionState = validacionState,
        onValueChange = onValueChange
    )
}

@Composable
fun OutlinedTextFieldNombre(
    modifier: Modifier = Modifier,
    enabled: Boolean=true,
    label: String = "Nombre",
    nombreState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
)
{
    OutlinedTextFieldWithErrorState(
        modifier = modifier,
        label = label,
        enabled=enabled,
        textoState = nombreState,
        textoPista = "Nombre",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.TextFields,
                contentDescription = "Nombre"
            )
        },
        validacionState = validacionState,
        onValueChange = onValueChange
    )
}
@Composable
fun OutlinedTextFieldAltura(
    modifier: Modifier = Modifier,
    enabled: Boolean=true,
    label: String = "Altura",
    alturaState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
)
{


    OutlinedTextFieldWithErrorState(
        modifier = modifier,
        label = label,
        enabled=enabled,
        textoState = alturaState,
        textoPista = "Altura",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.AccessibilityNew,
                contentDescription = "Altura"
            )
        },
        validacionState = validacionState,
        onValueChange = onValueChange
    )
}
@Composable
fun OutlinedTextFieldPeso(
    modifier: Modifier = Modifier,
    enabled: Boolean=true,
    label: String = "Peso",
    pesoState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
)
{
    OutlinedTextFieldWithErrorState(
        modifier = modifier,
        label = label,
        enabled=enabled,
        textoState = pesoState,
        textoPista = "Peso",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Scale,
                contentDescription = "Peso"
            )
        },
        validacionState = validacionState,
        onValueChange = onValueChange
    )
}

