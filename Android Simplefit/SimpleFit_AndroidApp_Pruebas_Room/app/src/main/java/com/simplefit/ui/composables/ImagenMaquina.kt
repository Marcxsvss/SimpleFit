package com.simplefit.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face2
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ImagenMaquina(
    modifier: Modifier = Modifier,
    foto : ImageBitmap?,
    anchoBorde : Dp = 4.dp,
) {
    val imagenSinFoto = rememberVectorPainter(image = Icons.Filled.Face2)
    var painterFoto = remember(foto) {
        foto?.let { BitmapPainter(it) } ?: imagenSinFoto
    }
    Image(
        modifier = modifier.then(
            Modifier
                .clip(CircleShape)
                .aspectRatio(ratio = 1f)
                .background(MaterialTheme.colorScheme.surface)
                .border(
                    width = anchoBorde,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    shape = CircleShape
                )),
        painter = painterFoto,
        contentScale = ContentScale.Crop,
        contentDescription = "Imagen Maquina")
}