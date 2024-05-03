package com.simplefit.data

import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.rutinas.RutinasEntity
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.models.Rutinas
import com.simplefit.models.Usuario
import com.simplefit.ui.features.mainApp.routines.RoutinesUiState
import com.simplefit.ui.features.toRutinasUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RutinasRepository @Inject constructor(
    private val rutinasDao: RutinasDao,
    private val usuarioRutinasRepository: UsuarioRutinaRepository,
    private val usuarioDao: UsuarioDao
) {

    suspend fun get(userid: String): List<RoutinesUiState> =
        withContext(Dispatchers.IO)
        {
            val rutinaState = usuarioDao.get(userid).rutinaState //rutinaState es el id de la rutina que el usuario tiene seleccionada

            rutinasDao.get().filter { r ->
                r.rutinaid in usuarioRutinasRepository.get(userid).map { it.rutinaid } //Solo se muestran las rutinas que el usuario tiene agregadas
            }.map { if(rutinaState == it.rutinaid)it.toRutina().toRutinasUiState("current",userid)else it.toRutina().toRutinasUiState("Added",userid)}
            //Si es la rutina que tiene actualmente en curso, su estado será current

        }
    suspend fun get(): List<Rutinas> = withContext(Dispatchers.IO) {
        rutinasDao.get().map { it.toRutina() }
    }
    suspend fun getRutina(rutinaid : Int?): Rutinas = withContext(Dispatchers.IO) {
        rutinasDao.get(rutinaid).toRutina()
    }


    suspend fun update(rutina: Rutinas) = withContext(Dispatchers.IO) {
        rutinasDao.update(rutina.toRutinasEntity())
    }



}