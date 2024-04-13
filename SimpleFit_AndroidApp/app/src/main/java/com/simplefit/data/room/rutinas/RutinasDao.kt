package com.simplefit.data.room.rutinas

import androidx.room.*
import com.pmdm.tienda.data.room.cliente.UsuarioEntity


@Dao
interface RutinasDao {
    @Query("SELECT * FROM rutinas")
    suspend fun get(): List<RutinasEntity>

    @Query("SELECT * FROM rutinas WHERE userId IN (:userId)")
    suspend fun get(userId:Int): RutinasEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rutina: RutinasEntity)

    @Update
    suspend fun update(rutina: RutinasEntity)

    @Query("SELECT COUNT(*) FROM rutinas")
    suspend fun count(): Int
}