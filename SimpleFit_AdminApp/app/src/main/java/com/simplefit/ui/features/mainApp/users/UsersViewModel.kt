package com.simplefit.ui.features.mainApp.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.RutinasRepository
import com.simplefit.data.UsuarioRepository
import com.simplefit.data.UsuarioRutinaRepository
import com.simplefit.ui.features.toRutinasUiState
import com.simplefit.ui.features.toUsuario
import com.simplefit.ui.features.toUsuarioUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository,
    private val usuarioRutinaRepository: UsuarioRutinaRepository
) : ViewModel() {
    var usersUiState by mutableStateOf(UsersUiState())
        private set
    var usersList by mutableStateOf(listOf<UsersUiState>())
        private set

    var mostrarDialog by mutableStateOf(false)

    val onMostrarDialog: (Boolean) -> Unit by mutableStateOf({
        mostrarDialog = it
    })
    var busquedaState by mutableStateOf("")
    fun setUsers() {
        viewModelScope.launch {
            usersList = usuarioRepository.get().map { it.toUsuarioUiState() }
            usersUiState = UsersUiState()
        }

    }
    fun onUsersEvent(usersEvent: UsersEvent) {
        when (usersEvent) {
            is UsersEvent.onUserClicked -> {
                usersUiState = usersList.find { it.email == usersEvent.email }!!
            }

            is UsersEvent.onVerClicked -> {
                usersEvent.onNavigateToVerRutina?.let { it(usersUiState) }
            }

            is UsersEvent.onDeleteClicked -> {
                viewModelScope.launch {
                    //usuarioRutinaRepository.deleteUserRoutines(usersUiState.email)
                    usuarioRepository.delete(usersUiState.email)
                    usersList = usuarioRepository.get().map { it.toUsuarioUiState() }
                    usersUiState = UsersUiState()
                }
            }
            is UsersEvent.onCancelClicked -> {
                usersUiState = UsersUiState()
            }
            is UsersEvent.onCargoChanged -> {
                usersUiState = usersUiState.copy(acceso = if(usersEvent.user.acceso == 1) 0 else 1 )
                viewModelScope.launch {
                    usuarioRepository.update(usersUiState.toUsuario())
                    usersList = usuarioRepository.get().map { it.toUsuarioUiState() }}
            }

            is UsersEvent.onSearchChanged -> {
                busquedaState = usersEvent.texto
                viewModelScope.launch {
                    usersList = usuarioRepository.get().map { it.toUsuarioUiState() }.filter {
                        it.email.lowercase(Locale.ROOT).contains(usersEvent.texto) ||
                                (if (it.acceso == 1) "Administrador" else "Usuario").lowercase(Locale.ROOT).contains(
                                    usersEvent.texto
                                ) ||
                                it.nombre.lowercase(Locale.ROOT).contains(usersEvent.texto)
                    }
                }
            }

            else -> {}
        }
    }
}