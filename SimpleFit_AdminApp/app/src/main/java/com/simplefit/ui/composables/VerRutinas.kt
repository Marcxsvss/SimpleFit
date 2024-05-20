package com.simplefit.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefitAdmin.R

@Composable
fun DescansoScreen()
{
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp))
    {
        Text(
            text = "Descanso",
            fontSize = 30.sp,
            textAlign = TextAlign.Start,
            color = Color(0xFFDAB338),
            fontFamily = FontFamily(
                Font(resId = R.font.bayon_regular)
            )
        )
        HorizontalDivider(
            modifier = Modifier.padding(bottom = 10.dp),
            thickness = 1.dp,
            color = Color(0xFFDAB338)
        )
        Text(
            text = "No hay ejercicios para hoy, asegúrate dormir y comer de forma saludable para la correcta recuperacion de tus músculos¡¡",
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            color = Color(0xFFDAB338),
            fontFamily = FontFamily(
                Font(resId = R.font.roboto_blackitalic)
            )

        )
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .aspectRatio(ratio = 1f)
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.recuperacion),
            contentDescription = "Imagen objetivo"
        )
    }
}