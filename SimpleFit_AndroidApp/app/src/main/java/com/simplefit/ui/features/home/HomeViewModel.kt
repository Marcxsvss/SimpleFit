package com.simplefit.ui.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplefit.data.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var homeUiState by mutableStateOf(HomeUiState())
        private set
    var indexState by mutableStateOf(0)
    fun setUsuario(email : String)
    {

        homeUiState = homeUiState.copy(
            email = email
        )

    }
    fun onHomeEvent(homeEvent: HomeEvent) {
        when (homeEvent) {

            is HomeEvent.onNavigateToScreen -> {
                indexState = homeEvent.index
            }
            is HomeEvent.OnClickDailyCheck-> {
                viewModelScope.launch {


                }
            }

            else -> {}
        }
    }
}