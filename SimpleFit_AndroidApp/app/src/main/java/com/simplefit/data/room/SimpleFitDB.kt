package com.pmdm.recetas.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.simplefit.data.room.usuario.UsuarioDao
import com.pmdm.tienda.data.room.cliente.UsuarioEntity


@TypeConverters(RoomConverters::class)
@Database(
    entities = [UsuarioEntity::class],
    version = 3
)
abstract class SimpleFitDB : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
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