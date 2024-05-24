package com.simplefit

import android.app.Application
import com.simplefit.data.room.maquinas.MaquinasDao
import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaDao
import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.data.room.usuarioRutina.UsuarioRutinaDao
import com.simplefit.data.toMaquina
import com.simplefit.data.toMaquinaEntity
import com.simplefit.data.toRutina
import com.simplefit.data.toRutinaMaquina
import com.simplefit.data.toRutinaMaquinaEntity
import com.simplefit.data.toRutinasEntity
import com.simplefit.data.toUsuario
import com.simplefit.data.toUsuarioEntity
import com.simplefit.data.toUsuarioRutina
import com.simplefit.data.toUsuarioRutinaEntity
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class SimpleFitAdminApplication: Application (){

    override fun onCreate() {

        super.onCreate()

    }
}