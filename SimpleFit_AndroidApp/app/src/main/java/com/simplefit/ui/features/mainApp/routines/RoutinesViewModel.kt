package com.simplefit.ui.features.mainApp.routines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.simplefit.data.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RoutinesViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var routinesUiState by mutableStateOf(RoutinesUiState())
        private set


    fun onRoutinesEvent(routinesEvent: RoutinesEvent) {
        when (routinesEvent) {
            is RoutinesEvent.onCreateNewRoutine -> {

            }

            else -> {}
        }
    }
}