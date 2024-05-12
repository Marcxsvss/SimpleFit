package com.simplefit.data.room.consejos

import androidx.room.*
import com.simplefit.models.Consejo
import com.simplefit.models.Maquina


@Dao
interface ConsejosDao {

    @Query("SELECT consejo FROM consejos")
    suspend fun get(): List<String>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(consejo: ConsejosEntity)

    @Update
    suspend fun update(consejo: ConsejosEntity)

    @Query("SELECT COUNT(*) FROM consejos")
    suspend fun count(): Int

    @Query("DELETE FROM consejos WHERE consejoid IN (:consejoid)")
    suspend fun delete(consejoid: Int)
}