package com.simplefit.ui.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.simplefit.data.UsuarioRepository
import com.simplefit.ui.features.profileInfoRegister.RegisterProfileInfoUiState
import com.simplefit.ui.features.profileInfoRegister.ValidadorRegisterProfileInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val validadorRegisterProfileInfo: ValidadorRegisterProfileInfo,
    private val usuarioRepository: UsuarioRepository
) : ViewModel() {
    var HomeUiState by mutableStateOf(HomeUiState())
        private set
    
}