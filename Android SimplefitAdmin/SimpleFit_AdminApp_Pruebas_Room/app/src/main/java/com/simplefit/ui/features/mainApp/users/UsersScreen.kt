package com.simplefit.ui.features.mainApp.users

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.pmdm.recetas.ui.composables.OutlinedTextFieldSearch
import com.simplefit.ui.composables.UsersListItem
import com.simplefitAdmin.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UsersScreen(
    usersState: List<UsersUiState>,
    usuarioSeleccionadoState: UsersUiState?,
    onUsersEvent: (UsersEvent) -> Unit,
    onNavigateUp: () -> Unit,
    mostrarDialog: Boolean,
    onMostrarDialog: (Boolean) -> Unit,
    busquedaState: String,
) {
    Surface(
        modifier = Modifier.fillMaxSize()

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
//            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
//
//                IconButton(onClick = { onNavigateUp() })
//                {
//                    Icon(
//                        tint = Color(0xFFDAB338),
//                        imageVector = Icons.Filled.ArrowBackIosNew,
//                        contentDescription = "Volver atras"
//                    )
//                }
//                Text(
//                    modifier = Modifier.padding(start = 50.dp, top = 6.dp),
//                    text = "USUARIOS",
//                    color = Color(0xFFDAB338),
//                    fontSize = 30.sp,
//                    fontStyle = FontStyle.Italic
//                )
//            }
            Box(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { onNavigateUp() }, modifier = Modifier.align(Alignment.CenterStart))
                {
                    Icon(
                        tint = Color(0xFFDAB338),
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Volver atras"
                    )
                }
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "USUARIOS",
                    color = Color(0xFFDAB338),
                    fontSize = 30.sp,
                    fontFamily = FontFamily(
                        Font(resId = R.font.roboto_blackitalic)
                    )
                )



            }

            if (usuarioSeleccionadoState!!.email.isBlank()) {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(75.dp)
                ) {
                    OutlinedTextFieldSearch(
                        modifier = Modifier,
                        enabled = true,
                        label = "",
                        busquedaState = busquedaState,
                        onValueChange = { onUsersEvent(UsersEvent.onSearchChanged(it)) },
                    )

                }
                Spacer(modifier = Modifier.height(20.dp))
            }

            if (usuarioSeleccionadoState.email.isNotBlank()) {


                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .height(75.dp)
                ) {


                    IconButton(onClick = { onMostrarDialog(true) })
                    {
                        Icon(
                            tint = Color(0xFFDAB338),
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Editar Usuario"
                        )
                    }
                    IconButton(onClick = { onUsersEvent(UsersEvent.onDeleteClicked) })
                    {
                        Icon(
                            tint = Color(0xFFDAB338),
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Eliminar Rutina",
                        )
                    }
                    IconButton(onClick = { onUsersEvent(UsersEvent.onCancelClicked) })
                    {
                        Icon(
                            tint = Color(0xFFDAB338),
                            imageVector = Icons.Filled.Cancel,
                            contentDescription = "Cancelar"
                        )
                    }


                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    contentPadding = PaddingValues(all = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(
                        usersState,
                        key = { it.email }
                    ) { user ->
                        UsersListItem(
                            onVerUserClicked = {},
                            modifier = Modifier.animateItemPlacement(),
                            userUiState = user,
                            seleccionadoState = usuarioSeleccionadoState?.let { it.email == user.email }
                                ?: false,
                            onUserClicked = {
                                onUsersEvent(
                                    UsersEvent.onUserClicked(
                                        user.email
                                    )
                                )
                            }
                        )
                    }
                }

            }
        }
        if (mostrarDialog) {
            AlertDialog(
                onDismissRequest = { onMostrarDialog(false) },
                title = {
                    Text(
                        text = "USUARIO", color = Color(0xFFDAB338), fontSize = 28.sp,
                        fontFamily = FontFamily(
                            Font(resId = R.font.roboto_bolditalic)
                        ),
                    )
                },
                text = {
                    Column {
                        Text(
                            "Email: " + usuarioSeleccionadoState!!.email,
                            color = Color(0xFFDAB338),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(resId = R.font.roboto_mediumitalic)
                            )
                        )
                        Text(
                            "Nombre: " + usuarioSeleccionadoState.nombre,
                            color = Color(0xFFDAB338),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(resId = R.font.roboto_mediumitalic)
                            )
                        )
                        Text(
                            "Rango: " + if (usuarioSeleccionadoState.acceso == 1) "ADMINISTRADOR" else "USUARIO",
                            color = Color(0xFFDAB338),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(resId = R.font.roboto_mediumitalic)
                            )
                        )
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        onUsersEvent(UsersEvent.onCargoChanged(usuarioSeleccionadoState!!))
                        onMostrarDialog(false)
                    }) {
                        Text(if (usuarioSeleccionadoState!!.acceso == 1) "Quitar Administrador" else "Dar Administrador")
                    }
                    Button(onClick = { onMostrarDialog(false) }) {
                        Text("OK")
                    }
                }
            )
        }

    }
}
