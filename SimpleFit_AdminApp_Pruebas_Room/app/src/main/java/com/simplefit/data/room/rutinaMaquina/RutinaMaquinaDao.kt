package com.simplefit.data.room.rutinaMaquina

import androidx.room.*


@Dao
interface RutinaMaquinaDao {
    @Query("SELECT * FROM rutinamaquina")
    suspend fun get(): List<RutinaMaquinaEntity>

    @Query("SELECT maquinaid FROM rutinamaquina WHERE rutinaid = :rutinaid AND dia = :dia")
    suspend fun get(rutinaid:Int, dia : String): List<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rutina: RutinaMaquinaEntity)

    @Update
    suspend fun update(maquina: RutinaMaquinaEntity)

    @Query("SELECT COUNT(*) FROM rutinamaquina")
    suspend fun count(): Int

    @Query("DELETE FROM rutinas WHERE rutinaid IN (:rutinaid)")
    suspend fun delete(rutinaid: Int)
}