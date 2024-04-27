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
    private val usuarioRutinasRepository: UsuarioRutinaRepository
) {
//    suspend fun get(userid: String): List<Rutinas> = //Lista de rutinas de un usuario
//        withContext(Dispatchers.IO) {
//
//            rutinasDao.get().filter { r -> r.rutinaid in usuarioRutinasRepository.get(userid).map { it.rutinaid } }.map { it.toRutina() }
//        }
    suspend fun get(userid: String): List<RoutinesUiState> =
        withContext(Dispatchers.IO)
        {
            val rutinasUserList = usuarioRutinasRepository.get(userid)
            val rutinas = rutinasDao.get().filter { r ->
                r.rutinaid in rutinasUserList.map { it.rutinaid }
            }.map { it.toRutina().toRutinasUiState() }
            rutinas.map { rc ->
                rc.copy(objetivo = rutinasUserList.find { it.rutinaid == rc.rutinaid }!!.objetivo)
            }
        }
    suspend fun get(): List<Rutinas> = withContext(Dispatchers.IO) {
        rutinasDao.get().map { it.toRutina() }
    }


    suspend fun update(rutina: Rutinas) = withContext(Dispatchers.IO) {
        rutinasDao.update(rutina.toRutinasEntity())
    }

    suspend fun delete(rutinaid: Int) = withContext(Dispatchers.IO) {
        rutinasDao.delete(rutinaid)
    }

}