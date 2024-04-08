package com.simplefit.data.room.usuario

import androidx.room.*
import com.pmdm.tienda.data.room.cliente.UsuarioEntity


@Dao
interface UsuarioDao {
    @Query("SELECT * FROM USUARIOS")
    suspend fun get(): List<UsuarioEntity>

    @Query("SELECT * FROM usuarios WHERE email IN (:email)")
    suspend fun get(email:String): UsuarioEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: UsuarioEntity)

    @Update
    suspend fun update(usuario: UsuarioEntity)

    @Query("SELECT COUNT(*) FROM usuarios")
    suspend fun count(): Int
}