package com.simplefit.data.room.usuarioRutina

import androidx.room.*


@Dao
interface UsuarioRutinaDao {
    @Query("SELECT * FROM usuariorutina")
    suspend fun get(): List<UsuarioRutinaEntity>

    @Query("SELECT * FROM usuariorutina WHERE userid = :userid")
    suspend fun get(userid:String): List<UsuarioRutinaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rutina: UsuarioRutinaEntity)

    @Query("DELETE FROM usuariorutina WHERE userid IN (:userid)")
    suspend fun deleteAllRutinas(userid: String)

    @Query("DELETE FROM usuariorutina WHERE rutinaid IN (:rutinaid)")
    suspend fun deleteRutina(rutinaid: Int)

    @Query("SELECT COUNT(*) FROM usuariorutina")
    suspend fun count(): Int
    @Update
    suspend fun update(maquina: UsuarioRutinaEntity)


}