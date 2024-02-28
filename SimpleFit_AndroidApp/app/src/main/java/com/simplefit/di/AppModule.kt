package com.simplefit.di

import android.content.Context
import com.pmdm.recetas.data.room.SimpleFitDB
import com.simplefit.data.room.usuario.UsuarioDao
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
        // La Bd es inyectada por provideAgendaDatabase() y
        // resuelto automáticamente por Hilt
        db: SimpleFitDB
    ) : UsuarioDao = db.usuarioDao()
}