package com.simplefit.di

import android.content.Context
import com.pmdm.recetas.data.room.SimpleFitDB
import com.simplefit.data.room.consejos.ConsejosDao
import com.simplefit.data.room.maquinas.MaquinasDao
import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaDao
import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.usuario.UsuarioDao
import com.simplefit.data.room.usuarioRutina.UsuarioRutinaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(
        @ApplicationContext context: Context
    ) : SimpleFitDB = SimpleFitDB.getDatabase(context)

    @Provides
    @Singleton
    fun provideUsersDao(
        db: SimpleFitDB
    ) : UsuarioDao = db.usuarioDao()
    @Provides
    @Singleton
    fun provideRoutinesDao(
        db: SimpleFitDB
    ) : RutinasDao = db.rutinasDao()
    @Provides
    @Singleton
    fun provideMaquinasDao(
        db: SimpleFitDB
    ) : MaquinasDao = db.maquinasDao()
    @Provides
    @Singleton
    fun provideRutinaMaquinaDao(
        db: SimpleFitDB
    ) : RutinaMaquinaDao = db.rutinaMaquinaDao()
    @Provides
    @Singleton
    fun provideUsuarioRutinaDao(
        db: SimpleFitDB
    ) : UsuarioRutinaDao = db.usuarioRutinaDao()
    @Provides
    @Singleton
    fun provideConsejos(
        db: SimpleFitDB
    ) : ConsejosDao = db.consejosDao()
}