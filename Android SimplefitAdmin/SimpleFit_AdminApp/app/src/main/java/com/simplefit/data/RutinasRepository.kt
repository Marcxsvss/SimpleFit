package com.simplefit.data


import com.simplefit.data.services.rutina.RutinasServiceImplementation
import com.simplefit.data.services.usuario.UsuarioServiceImplementation
import com.simplefit.data.services.usuariorutina.UsuarioRutinaServiceImplementation
import com.simplefit.models.Rutinas
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.toRutinasUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RutinasRepository @Inject constructor(
    private val rutinasServiceImplementation: RutinasServiceImplementation,
) {

    suspend fun get(): List<Rutinas> = withContext(Dispatchers.IO) {
        rutinasServiceImplementation.get().map { it.toRutina() }
    }
    suspend fun delete(rutinaid : Int) = withContext(Dispatchers.IO)
    {
        rutinasServiceImplementation.delete(rutinaid)
    }

}