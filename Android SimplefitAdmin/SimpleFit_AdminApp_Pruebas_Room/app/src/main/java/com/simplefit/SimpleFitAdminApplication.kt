package com.simplefit

import android.app.Application
import com.pmdm.recetas.data.mocks.UsuarioDaoMock
import com.simplefit.data.mocks.MaquinasDaoMock
import com.simplefit.data.mocks.RutinaMaquinaDaoMock
import com.simplefit.data.mocks.RutinasDaoMock
import com.simplefit.data.mocks.UsuarioRutinaDaoMock

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
    @Inject
    lateinit var UsuariosDaoMock: UsuarioDaoMock
    @Inject
    lateinit var UsuariosDaoEntity: UsuarioDao
    @Inject
    lateinit var RutinasDaoMock: RutinasDaoMock
    @Inject
    lateinit var RutinasDaoEntity: RutinasDao
    @Inject
    lateinit var MaquinasDaoMock: MaquinasDaoMock
    @Inject
    lateinit var MaquinasDaoEntity: MaquinasDao
    @Inject
    lateinit var RutinaMaquinaDaoMock: RutinaMaquinaDaoMock
    @Inject
    lateinit var RutinaMaquinaDaoEntity: RutinaMaquinaDao
    @Inject
    lateinit var UsuarioRutinaDaoMock: UsuarioRutinaDaoMock
    @Inject
    lateinit var UsuarioRutinaDaoEntity: UsuarioRutinaDao

    override fun onCreate() {

        super.onCreate()

        runBlocking {
            if(UsuariosDaoEntity.count() == 0)
                UsuariosDaoMock.get().forEach {UsuariosDaoEntity.insert(it.toUsuario().toUsuarioEntity())}

            if(RutinasDaoEntity.count() == 0)
                RutinasDaoMock.get().forEach {RutinasDaoEntity.insert(it.toRutina().toRutinasEntity())}

            if(MaquinasDaoEntity.count() == 0)
                MaquinasDaoMock.get().forEach {MaquinasDaoEntity.insert(it.toMaquina().toMaquinaEntity())}

            if(RutinaMaquinaDaoEntity.count() == 0)
                RutinaMaquinaDaoMock.get().forEach {RutinaMaquinaDaoEntity.insert(it.toRutinaMaquina().toRutinaMaquinaEntity())}

            if(UsuarioRutinaDaoEntity.count() == 0)
                UsuarioRutinaDaoMock.get().forEach {UsuarioRutinaDaoEntity.insert(it.toUsuarioRutina().toUsuarioRutinaEntity())}

        }
    }
}