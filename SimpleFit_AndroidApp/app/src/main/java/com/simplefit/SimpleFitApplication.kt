package com.simplefit

import android.app.Application
import com.pmdm.recetas.data.mocks.UsuarioDaoMock
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.data.toUsuario
import com.simplefit.data.toUsuarioEntity
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class SimpleFitApplication: Application (){
//    @Inject
//    lateinit var UsuariosDaoMock: UsuarioDaoMock
//    @Inject
//    lateinit var UsuariosDaoEntity: UsuarioDao
//
//    override fun onCreate() {
//        super.onCreate()
//
//        runBlocking {
//            if(UsuariosDaoEntity.count() == 0)
//                UsuariosDaoMock.get().forEach { UsuariosDaoEntity.insert(it.toUsuario().toUsuarioEntity())}
//        }
//    }
}