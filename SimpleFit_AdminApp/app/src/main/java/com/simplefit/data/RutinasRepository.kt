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
    private val usuarioRutinasRepository: UsuarioRutinaRepository,
    private val rutinasServiceImplementation: RutinasServiceImplementation,
    private val usuarioRutinaServiceImplementation: UsuarioRutinaServiceImplementation,
    private val usuarioServiceImplementation: UsuarioServiceImplementation,
) {


    suspend fun get(userid: String): List<RoutinesUiState> =
        withContext(Dispatchers.IO)
        {
            val rutinaState = usuarioServiceImplementation.get(userid).rutinastate //rutinaState es el id de la rutina que el usuario tiene seleccionada
            rutinasServiceImplementation.get().filter { r ->
                r.rutinaid in usuarioRutinaServiceImplementation.get(userid).map { it.rutinaid } //Solo se muestran las rutinas que el usuario tiene agregadas
            }.map { if(rutinaState == it.rutinaid)it.toRutina().toRutinasUiState("current",userid)else it.toRutina().toRutinasUiState("Added",userid)}
            //Si es la rutina que tiene actualmente en curso, su estado será current
        }
    suspend fun get(): List<Rutinas> = withContext(Dispatchers.IO) {
        rutinasServiceImplementation.get().map { it.toRutina() }
    }
    suspend fun delete(rutinaid : Int) = withContext(Dispatchers.IO)
    {
        rutinasServiceImplementation.delete(rutinaid)
    }

}