package com.pmdm.recetas.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.simplefit.data.room.usuario.UsuarioDao
import com.pmdm.tienda.data.room.cliente.UsuarioEntity
import com.simplefit.data.room.maquinas.MaquinasDao
import com.simplefit.data.room.maquinas.MaquinasEntity
import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaDao
import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaEntity
import com.simplefit.data.room.rutinas.RutinasDao
import com.simplefit.data.room.rutinas.RutinasEntity
import com.simplefit.data.room.usuarioRutina.UsuarioRutinaDao
import com.simplefit.data.room.usuarioRutina.UsuarioRutinaEntity


@TypeConverters(RoomConverters::class)
@Database(
    entities = [UsuarioEntity::class, RutinasEntity::class, MaquinasEntity::class, RutinaMaquinaEntity::class, UsuarioRutinaEntity::class],
    version = 11
)
abstract class SimpleFitDB : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun rutinasDao(): RutinasDao
    abstract fun rutinaMaquinaDao(): RutinaMaquinaDao
    abstract fun maquinasDao(): MaquinasDao
    abstract fun usuarioRutinaDao(): UsuarioRutinaDao
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