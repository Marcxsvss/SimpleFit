package com.pmdm.recetas.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.simplefit.data.room.usuario.UsuarioDao
import com.pmdm.tienda.data.room.cliente.UsuarioEntity
import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.rutinas.RutinasEntity


@TypeConverters(RoomConverters::class)
@Database(
    entities = [UsuarioEntity::class, RutinasEntity::class],
    version = 6
)
abstract class SimpleFitDB : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun rutinasDao(): RutinasDao
    companion object {
       @Volatile
       private var db: SimpleFitDB? = null
        fun getDatabase(context: Context) = Room.databaseBuilder(
            context,
            SimpleFitDB::class.java, "SimpleFit"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}