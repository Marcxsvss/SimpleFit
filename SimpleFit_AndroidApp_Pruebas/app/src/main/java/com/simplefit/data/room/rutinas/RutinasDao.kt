package com.simplefit.data.room.rutinas

import androidx.room.*
import com.pmdm.tienda.data.room.cliente.UsuarioEntity


@Dao
interface RutinasDao {
    @Query("SELECT * FROM rutinas")
    suspend fun get(): List<RutinasEntity>

    @Query("SELECT * FROM rutinas WHERE userid IN (:userid)")
    suspend fun get(userid:String): List<RutinasEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rutina: RutinasEntity)

    @Update
    suspend fun update(rutina: RutinasEntity)

    @Query("SELECT COUNT(*) FROM rutinas")
    suspend fun count(): Int

    @Query("DELETE FROM rutinas WHERE rutinaid IN (:rutinaid)")
    suspend fun delete(rutinaid: Int)
}