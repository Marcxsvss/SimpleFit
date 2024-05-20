//package com.simplefit.data.room.maquinas
//
//import androidx.room.*
//import com.simplefit.data.room.rutinaMaquina.RutinaMaquinaEntity
//import com.simplefit.models.Maquina
//
//
//@Dao
//interface MaquinasDao {
//    @Query("SELECT * FROM maquinas")
//    suspend fun get(): List<Maquina>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(maquina: MaquinasEntity)
//
//    @Update
//    suspend fun update(maquina: MaquinasEntity)
//
//    @Query("SELECT COUNT(*) FROM maquinas")
//    suspend fun count(): Int
//
//    @Query("DELETE FROM maquinas WHERE maquinaid IN (:maquinaid)")
//    suspend fun delete(maquinaid: Int)
//}