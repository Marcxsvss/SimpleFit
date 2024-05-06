package com.kinoyamboladmin.ui.features.movieform

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun IconCamera(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(96.dp)
            .padding(4.dp),
//            .clip(CircleShape)
//            .border(
//                border = BorderStroke(
//                    width = 1.dp,
//                    color = OutlinedTextFieldDefaults.colors().unfocusedLeadingIconColor
//                ),
//                shape = CircleShape,
//           ),
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
    image: Uri?,
    label: String,
    onChangePhoto: () -> Unit
) {
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
            .clickable { onChangePhoto() },
        contentAlignment = Alignment.Center
    ) {
        if (image != null) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                    //.clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
                model = image,
                contentDescription = "front page"
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconCamera()
//            Text(
//                text = label,
//                color = OutlinedTextFieldDefaults.colors().unfocusedLabelColor,
//                fontSize = MaterialTheme.typography.labelLarge.fontSize
//            )
        }
    }
}
