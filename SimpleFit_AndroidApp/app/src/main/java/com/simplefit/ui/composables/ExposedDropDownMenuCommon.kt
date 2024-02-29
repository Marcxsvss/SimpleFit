package com.simplefit.ui.composables

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import com.simplefit.ui.theme.SimpleFitTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxEdad(/*edadState: Int, */onValueChange: (Int) -> Unit, modifier: Modifier) {
    val context = LocalContext.current
    val Edades = arrayOf("16-28", "28-45", "45-60", "60-X")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(Edades[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = !expanded})
        {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                Edades.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            onValueChange(item.toInt())
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxSexo(/*sexoState: Int, */onValueChange: (String) -> Unit, modifier: Modifier) {
    val context = LocalContext.current
    val Edades = arrayOf("Masculino", "Femenino")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(Edades[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = !expanded})
        {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                Edades.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            onValueChange(item)
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxSomatotipo(/*somatotipoState: Int, */onValueChange: (String) -> Unit, modifier: Modifier) {
    val context = LocalContext.current
    val Edades = arrayOf("Ectomorfo", "Mesomorfo", "Endomorfo")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(Edades[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = !expanded})
        {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                Edades.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            onValueChange(item)
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxAlergia(/*sexoState: Int, */onValueChange: (String) -> Unit, modifier: Modifier) {
    val context = LocalContext.current
    val Edades = arrayOf("Lactosa", "Gluten", "Pescado", "Huevo")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember {mutableStateOf(Edades[0])}

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = !expanded})
        {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                Edades.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            onValueChange(item)
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
//@Preview
//@Composable
//fun ExposedDropdownMenuBoxEdadPreview() {
//    SimpleFitTheme {
//        ExposedDropdownMenuBoxEdad({}, modifier = Modifier)
//    }
//}