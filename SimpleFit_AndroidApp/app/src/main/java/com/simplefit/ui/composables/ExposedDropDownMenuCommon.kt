package com.simplefit.ui.composables

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.simplefit.R
import com.simplefit.ui.theme.SimpleFitTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxEdad(
    edadState: String = "Edad",
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {

    val context = LocalContext.current
    val Edades = arrayOf("16-28", "28-45", "45-60", "60-X")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(edadState) }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Column()
        {
            Text(
                text = "Edad",
                color = Color(0xFFDAB338),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(resId = R.font.bayon_regular)
                )
            )
            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded })
            {
                TextField(
                    value = if (selectedText.isNullOrBlank()) "Edad" else selectedText,
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxSexo(
    sexoState: String = "Sexo",
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    val Edades = arrayOf("Masculino", "Femenino")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(sexoState) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Column()
        {
            Text(
                text = "Sexo",
                color = Color(0xFFDAB338),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(resId = R.font.bayon_regular)
                )
            )
            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded })
            {
                TextField(
                    value = if (selectedText.isNullOrBlank()) "Sexo" else selectedText,
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxSomatotipo(
    somatotipoState: String = "Somatotipo",
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    val somatotipo = arrayOf("Ectomorfo", "Mesomorfo", "Endomorfo")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(somatotipoState) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Column()
        {
            Text(
                text = "Somatotipo",
                color = Color(0xFFDAB338),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(resId = R.font.bayon_regular)
                )
            )
            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded })
            {
                TextField(
                    value = if (selectedText.isNullOrBlank()) "Somatotipo" else selectedText,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    somatotipo.forEach { item ->
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxIntolerancia(
    intoleranciaState: String = "Intolerancia",
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    val Intolerancias = arrayOf("Lactosa", "Gluten")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(intoleranciaState) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Column()
        {
            Text(
                text = "Intolerancia",
                color = Color(0xFFDAB338),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(resId = R.font.bayon_regular)
                )
            )
            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded })
            {
                TextField(
                    value = if (selectedText.isNullOrBlank()) "Intolerancia" else selectedText,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    Intolerancias.forEach { item ->
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
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxFrecuencia(
    textoState: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    val Edades = arrayOf("1", "2","3")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(textoState) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Column()
        {
            Text(
                text = textoState,
                color = Color(0xFFDAB338),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(resId = R.font.bayon_regular)
                )
            )
            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded })
            {
                TextField(
                    value = selectedText.ifBlank { textoState },
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
}
//@Preview
//@Composable
//fun ExposedDropdownMenuBoxEdadPreview() {
//    SimpleFitTheme {
//        ExposedDropdownMenuBoxEdad({}, modifier = Modifier)
//    }
//}