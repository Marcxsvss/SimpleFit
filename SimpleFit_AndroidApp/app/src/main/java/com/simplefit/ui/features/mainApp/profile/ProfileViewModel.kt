package com.simplefit.ui.features.mainApp.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.simplefit.data.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var profileUiState by mutableStateOf(ProfileUiState())
        private set


    fun onProfileEvent(profileEvent: ProfileEvent) {
        when (profileEvent) {
            is ProfileEvent.OnClickLogOut -> {

            }

            else -> {}
        }
    }
}