package com.simplefit.ui.features.mainApp.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {
    var userMail by mutableStateOf("")
        private set


    fun setUsuario(email: String) {
        viewModelScope.launch {
            userMail = email
        }
    }
}