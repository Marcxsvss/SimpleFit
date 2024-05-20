package com.simplefit.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefitAdmin.R

@Composable
fun CloudButton(texto : String,onTodasClicked: () -> Unit? = {},onFiltroClicked: () -> Unit? = {})
{
    Button(
        onClick = {if(texto == "TODAS") onTodasClicked() else onFiltroClicked()},
        colors = ButtonColors(
            containerColor = Color(0xFFDBC06D),
            contentColor = Color.White,
            disabledContainerColor =  Color.White,
            disabledContentColor = Color.White
        ),

    )
    {
        Text(
            text = texto,
            color = Color.White,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
            fontStyle = FontStyle.Normal
        )
        if(texto == "FILTROS")
            Icon(Icons.Filled.FilterList, contentDescription = "Filtro",modifier = Modifier.padding(start=8.dp))
    }

}
@Composable
fun HomeButton(texto : String,onNavigateTo :() -> Unit)
{
    Box(
        Modifier
            .width(358.dp)
            .height(100.dp)
            .background(
                color = Color(0xFFDAB338),
                shape = RoundedCornerShape(
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                    topStart = 10.dp
                )
            )
            .clickable { onNavigateTo() }
    ) {
//        Image(
//            painter = foto,
//            contentDescription = "Fondo",
//            modifier = Modifier.fillMaxSize()
//                .clip(RoundedCornerShape(10.dp)),
//            contentScale = ContentScale.Crop
//        )
        Row(modifier = Modifier.align(Alignment.Center)) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = texto,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal
            )
        }
    }
}
@Preview
@Composable
fun CloudButtonPreview()
{
    CloudButton("TODAS")
}