package com.simplefit.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.pmdm.agenda.utilities.device.resgitroSelectorDeImagenesConGetContent


@Composable
fun IconCamera(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(96.dp)
            .padding(4.dp),
            contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Filled.CameraAlt,
            contentDescription = "camera",
            modifier = Modifier.size(ButtonDefaults.IconSize),
            tint = OutlinedTextFieldDefaults.colors().unfocusedLeadingIconColor
        )
    }
}

@Composable
fun ImageSelector(
    modifier: Modifier = Modifier,
    selectImageBitmap: ImageBitmap? = null,
    onImageChanged: (ImageBitmap) -> Unit
) {
    val photopickerLauncher = resgitroSelectorDeImagenesConGetContent { imagebitmap ->
        onImageChanged(imagebitmap)
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .border(
                border = BorderStroke(
                    width = 2.dp,
                    color = OutlinedTextFieldDefaults.colors().unfocusedLabelColor
                ),
                shape = CircleShape
            )
            .clickable {photopickerLauncher.launch("image/*") },
        contentAlignment = Alignment.Center
    ) {
        if (selectImageBitmap != null) {
            Image(
                modifier = Modifier.size(115.dp),
                bitmap = selectImageBitmap,
                contentDescription = "Imagen ejercicio"
            )
        }
        else
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IconCamera()
            }
        }

    }
}
