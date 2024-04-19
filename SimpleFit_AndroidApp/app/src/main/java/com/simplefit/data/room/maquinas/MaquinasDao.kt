package com.simplefit.data.room.maquinas

import androidx.room.*


@Dao
interface MaquinasDao {
    @Query("SELECT * FROM rutinas")
    suspend fun get(): List<MaquinasEntity>

    @Query("SELECT * FROM rutinas WHERE userid IN (:userid)")
    suspend fun get(userid:String): List<MaquinasEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rutina: MaquinasEntity)

    @Update
    suspend fun update(rutina: MaquinasEntity)

    @Query("SELECT COUNT(*) FROM rutinas")
    suspend fun count(): Int

    @Query("DELETE FROM rutinas WHERE rutinaid IN (:rutinaid)")
    suspend fun delete(rutinaid: Int)
}