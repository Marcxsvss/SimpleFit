package com.simplefit.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face2
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simplefitAdmin.R
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.mainApp.users.UsersEvent
import com.simplefit.ui.features.mainApp.users.UsersUiState

@Composable
fun DatosUsuario(
    modifier: Modifier = Modifier,
    email: String,
    nombre: String,
    acceso : Int,
) {
    Column(
        modifier = modifier.then(
//            if (titulo.isNotBlank()) {
//                Modifier.width(172.dp)
//            } else {
            Modifier
                .width(250.dp)
                .padding(start = 12.dp, top = 10.dp)
            //}
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    )
    {
        Text(
            modifier = modifier.padding(top = 7.dp),
            text = email,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontStyle = FontStyle.Normal
        )
        Row()
        {
            Text(
                text = "$nombre | ",
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF89602F),//MaterialTheme.colorScheme.secondary,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal
            )

            Text(
                text = if(acceso == 1) "Administrador" else "Usuario",
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF89602F),//MaterialTheme.colorScheme.secondary,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal,

                )
        }

    }


}
@Composable
fun DatosRutina(
    modifier: Modifier = Modifier,
    titulo: String,
    frecuencia: Int,
    diasDescanso: Int,
    dificultad: String,
    rutinaid : Int
) {
    Column(
        modifier = modifier.then(
            if (titulo.isNotBlank()) {
                Modifier.width(200.dp)
            } else {
                Modifier
                    .width(250.dp)
                    .padding(start = 12.dp, top = 10.dp)
            }
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    )
    {
        Row(modifier = Modifier.padding(bottom = 5.dp)) {
            Text(
                modifier = modifier.padding(top = 7.dp),
                text = "ID: $rutinaid  |  ",
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,//MaterialTheme.colorScheme.secondary,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal
            )
            Text(
                modifier = modifier.padding(top = 7.dp),
                text = titulo,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontStyle = FontStyle.Normal
            )
        }

        Row()
        {
            Text(
                text = if (titulo.isNotBlank()) "$dificultad | " else "",
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF89602F),//MaterialTheme.colorScheme.secondary,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal
            )


            Text(
                text = "Frecuencia $frecuencia" + if (titulo.isBlank()) " | Desc: $diasDescanso Dias | $dificultad" else "",
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF89602F),//MaterialTheme.colorScheme.secondary,
                fontFamily = FontFamily(Font(R.font.roboto_blackitalic)),
                fontStyle = FontStyle.Normal,

                )
        }

    }


}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContenidoPrincipalCardRutina(
    rutinaUiState: RoutinesUiState,
    seleccionadoState: Boolean,
    modifier: Modifier = Modifier,
    onVerRutinaClicked: () -> Unit? = {}
) {
    Box(
        Modifier
            .height(90.dp)
            .fillMaxWidth()
            .background(
                color = if (seleccionadoState) Color(0xFFDAB338) else Color(0xFFDCCEA2),
                shape = RoundedCornerShape(
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                    topStart = 10.dp
                )
            )

//
    )
    {
        Row(
            modifier = modifier.then(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 15.dp)
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Usa FlowRow para que la imagen se superponga a los datos
            // de contacto cuando no haya suficiente espacio para ambos
            FlowRow(
                horizontalArrangement = Arrangement.Center
            ) {
                DatosRutina(
                    modifier = Modifier,
                    rutinaid = rutinaUiState.rutinaid,
                    titulo = rutinaUiState.titulo,
                    frecuencia = rutinaUiState.frecuencia,
                    diasDescanso = rutinaUiState.diasDescanso,
                    dificultad = rutinaUiState.dificultad
                )

                if (seleccionadoState) {
                    Box(modifier = Modifier.size(70.dp))
                    {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = "Flecha Derecha",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(top = 18.dp, start = 40.dp)
                                .clickable {
                                    onVerRutinaClicked()
                                })
                    }
                }


            }
        }
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContenidoCardUsuario(
    userUiState: UsersUiState,
    seleccionadoState: Boolean,
    modifier: Modifier = Modifier,
    onVerUserClicked: () -> Unit? = {}
) {
    Box(
        Modifier
            .height(90.dp)
            .fillMaxWidth()
            .background(
                color = if (seleccionadoState) Color(0xFFDAB338) else Color(0xFFDCCEA2),
                shape = RoundedCornerShape(
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                    topStart = 10.dp
                )
            )
    )
    {
        Row(
            modifier = modifier.then(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(5.dp)
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Usa FlowRow para que la imagen se superponga a los datos
            // de contacto cuando no haya suficiente espacio para ambos
            FlowRow(
                horizontalArrangement = Arrangement.Center
            ) {
//                if (rutinaUiState.descripcion.isNotBlank()) {
//                    Box(
//                        modifier = Modifier
//                            .size(80.dp, 80.dp)
//                            .padding(8.dp),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Image(
//                            modifier = Modifier
//                                .clip(CircleShape)
//                                .aspectRatio(ratio = 1f)
//                                .background(Color.White)
//                                .border(
//                                    width = 1.dp,
//                                    color = Color.White,
//                                    shape = CircleShape
//                                ),
//                            contentScale = ContentScale.Crop,
//                            painter = painterResource(id = imageResource),
//                            contentDescription = "Imagen objetivo"
//                        )
//                    }
//                }
                DatosUsuario(
                    modifier = Modifier,
                    email = userUiState.email,
                    nombre = userUiState.nombre,
                    acceso = userUiState.acceso,
                )


            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RutinasListItem2(
    onVerRutinaClicked: () -> Unit? = {},
    modifier: Modifier = Modifier,
    rutinaUiState: RoutinesUiState,
    seleccionadoState: Boolean,
    onRutinaClicked: (Int) -> Unit
) {


    ElevatedCard(
        onClick = { onRutinaClicked(rutinaUiState.rutinaid) },
        modifier = modifier.then(
            Modifier
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .padding(6.dp)
        ),
    ) {

        val context = LocalContext.current

        Row {
            ContenidoPrincipalCardRutina(
                rutinaUiState = rutinaUiState,
                seleccionadoState = seleccionadoState,
                onVerRutinaClicked = onVerRutinaClicked
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RutinasListItem(
    onVerRutinaClicked: () -> Unit,
    modifier: Modifier = Modifier,
    rutinaUiState: RoutinesUiState,
    seleccionadoState: Boolean,
    onRutinaClicked: (Int) -> Unit,
) {
    ElevatedCard(
        onClick = { onRutinaClicked(rutinaUiState.rutinaid) },
        modifier = modifier.then(
            Modifier
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .padding(6.dp)
        ),
    ) {

        val context = LocalContext.current

        Row() {
            ContenidoPrincipalCardRutina(
                rutinaUiState = rutinaUiState,
                seleccionadoState = seleccionadoState,
                onVerRutinaClicked = onVerRutinaClicked
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersListItem(
    onVerUserClicked: () -> Unit,
    modifier: Modifier = Modifier,
    userUiState: UsersUiState,
    seleccionadoState: Boolean,
    onUserClicked: (String) -> Unit,
) {
    ElevatedCard(
        onClick = { onUserClicked(userUiState.email)
                  onVerUserClicked()},
        modifier = modifier.then(
            Modifier
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .padding(6.dp)
        ),
    ) {

        val context = LocalContext.current

        Row() {
            ContenidoCardUsuario(
                userUiState = userUiState,
                seleccionadoState = seleccionadoState,
                onVerUserClicked = onVerUserClicked
            )
        }
    }
}


@Preview(
    name = "PORTRAIT",
    device = "spec:width=360dp,height=800dp,dpi=480",
    showBackground = true
)
// Muestra OutlinedIconButton con los iconos de las
// acciones posibles sobre ul contacto seleccionado.
@Composable
fun AccionesRutina(
    onCompartirClicked: () -> Unit = {},
    onDeleteClicked: (Int) -> Unit = {}
) {
    data class Accion(
        val icon: ImageVector,
        val description: String,
        val onClick: (() -> Unit)? = null,
        val onClickDelete: ((Int) -> Unit)? = null
    )

    val acciones = remember {
        listOf(
            Accion(
                icon = Icons.Filled.Share,
                description = "Compartir",
                onClick = onCompartirClicked
            ),
            Accion(
                icon = Icons.Filled.Delete,
                description = "Eliminar",
                onClickDelete = onDeleteClicked
            )
        )
    }

    Row(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .animateContentSize { initialValue, targetValue -> },
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        for (accion in acciones) {
            accion.onClick?.let {
                OutlinedIconButton(
                    modifier = Modifier.padding(start = 8.dp),
                    onClick = it,
                ) {
                    Icon(
                        imageVector = accion.icon,
                        contentDescription = accion.description,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(70.dp))
    }
}

@Composable
fun ImagenRutina(
    modifier: Modifier = Modifier,
    foto: ImageBitmap?,
    anchoBorde: Dp = 4.dp,
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
                )
        ),
        painter = painterFoto,
        contentScale = ContentScale.Crop,
        contentDescription = "Imagen rutina objetivo"
    )
}