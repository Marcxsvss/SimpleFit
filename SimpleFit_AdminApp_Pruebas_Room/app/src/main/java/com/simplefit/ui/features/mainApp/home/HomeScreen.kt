package com.simplefit.ui.features.mainApp.home


import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefit.ui.composables.HomeButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToUsuarios: () -> Unit,
    onNavigateToRutinas: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "ADMINISTRACIÓN",
            color = Color(0xFFDAB338),
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(25.dp))
        HomeButton(
            onNavigateTo = onNavigateToUsuarios,
            texto = "USUARIOS",
        )
        Spacer(modifier = Modifier.height(25.dp))
        HomeButton(
            onNavigateTo = onNavigateToRutinas,
            texto = "RUTINAS",
        )


    }
}
