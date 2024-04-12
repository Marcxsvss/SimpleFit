package com.simplefit

import android.app.Application
import com.pmdm.recetas.data.mocks.UsuarioDaoMock
import com.simplefit.data.mocks.RutinasDaoMock
import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.data.toRutina
import com.simplefit.data.toRutinasEntity
import com.simplefit.data.toUsuario
import com.simplefit.data.toUsuarioEntity
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class SimpleFitApplication: Application (){
    @Inject
    lateinit var UsuariosDaoMock: UsuarioDaoMock
    @Inject
    lateinit var UsuariosDaoEntity: UsuarioDao
    @Inject
    lateinit var RutinasDaoMock: RutinasDaoMock
    @Inject
    lateinit var RutinasDaoEntity: RutinasDao

    override fun onCreate() {
        super.onCreate()

        runBlocking {
            if(UsuariosDaoEntity.count() == 0)
                UsuariosDaoMock.get().forEach {UsuariosDaoEntity.insert(it.toUsuario().toUsuarioEntity())}

            if(RutinasDaoEntity.count() == 0)
                RutinasDaoMock.get().forEach {RutinasDaoEntity.insert(it.toRutina().toRutinasEntity())}

        }
    }
}