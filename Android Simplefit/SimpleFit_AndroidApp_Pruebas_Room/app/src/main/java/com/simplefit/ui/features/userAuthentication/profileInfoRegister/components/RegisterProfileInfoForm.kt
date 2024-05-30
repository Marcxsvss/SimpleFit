package com.simplefit.ui.features.userAuthentication.profileInfoRegister.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pmdm.recetas.ui.composables.OutlinedTextFieldAltura
import com.pmdm.recetas.ui.composables.OutlinedTextFieldPeso
import com.pmdm.tienda.utilities.validacion.Validacion
import com.simplefit.ui.composables.ExposedDropdownMenuBoxEdad
import com.simplefit.ui.composables.ExposedDropdownMenuBoxSexo
import com.simplefit.ui.composables.ExposedDropdownMenuBoxSomatotipo

@Composable
fun RegisterProfileInfoForm(
    modifier: Modifier,
    edadState: String,
    sexoState: String,
    somatotipoState: String,
    alturaState: String,
    validacionAltura: Validacion,
    pesoState: String,
    validacionPeso: Validacion,
    onValueChangeEdad: (String) -> Unit,
    onValueChangeSexo: (String) -> Unit,
    onValueChangeSomatotipo: (String) -> Unit,
    onValueChangeAltura: (String) -> Unit,
    onValueChangePeso: (String) -> Unit,
    onClickGuardar: () -> Unit,

) {
    val scrollState = rememberScrollState()
    Column(verticalArrangement=  Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(20.dp)
            .padding(bottom = 56.dp)

    ) {
        OutlinedTextFieldAltura(
            alturaState = alturaState,
            validacionState = validacionAltura,
            onValueChange = onValueChangeAltura)
        OutlinedTextFieldPeso(
            pesoState = pesoState,
            validacionState = validacionPeso,
            onValueChange = onValueChangePeso)
        ExposedDropdownMenuBoxEdad(
            modifier = modifier,
            edadState = edadState,
            onValueChange = onValueChangeEdad
        )
        ExposedDropdownMenuBoxSexo(
            modifier = modifier,
            sexoState = sexoState,
            onValueChange = onValueChangeSexo
        )
        ExposedDropdownMenuBoxSomatotipo(
            modifier = modifier,
            somatotipoState = somatotipoState,
            onValueChange = onValueChangeSomatotipo
        )

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDAB338)),
            onClick = onClickGuardar,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=50.dp)
        ) {
            Text("Guardar preferencias")
        }
    }
}



