package com.simplefit.ui.features.mainApp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.simplefit.data.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainAppViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var userMail by mutableStateOf("")
        private set
    var UserUiState by mutableStateOf(MainAppUiState())
        private set
    fun setUsuario(email : String)
    {
        userMail = email
    }
    fun logOut()
    {
        userMail = ""
    }
}